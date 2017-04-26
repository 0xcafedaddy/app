/**
 * Created by zhangge on 15/11/17.
 */
var NativeAppService = {
        Field: {
            platform: "weixin"
        },

        chooseImage: function() {
            var messageId = MessageService.Field.idUserMessage++;
            wx.ready(function(){
                wx.chooseImage({
                    count: 1, // 默认9
                    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
                    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
                    success: function (res) {
                        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图

                        // 将上传中图片加入聊天康
                        var messageContent = MessageService.getDefaultUploadImage();
                        var messageHtml = UIService.createMessageUiForUser(messageContent, messageId);
                        initBottomFooter();

                        UIService.appendMessageHtml(messageHtml);
                        // 上传图片到微信服务器
                        NativeAppService.uploadImage(localIds, messageId);

                    }
                });
            });
            wx.error(function (res) {
                alert(res.errMsg);
            });
        },

        uploadImage: function (localId, messageId) {
            wx.ready(function(){
                wx.uploadImage({
                    localId: localId + '', // 需要上传的图片的本地ID，由chooseImage接口获得
                    isShowProgressTips: 0, // 默认为1，显示进度提示
                    success: function (res) {
                        var mediaId = res.serverId; // 返回图片的服务器端ID

                        // 图片上传完成后发送图片消息
                        setTimeout(function(){
                            UploadService.buildAndSendWXImage(localId, mediaId, messageId);
                            initBottomFooter();
                        },1000);
                    },
                    error : function (){
                        alert('图片上传失败, 请重试!');
                    }
                });
            });
        },
        /**
        * 判断是否在app里面
        */
        isApp: function () {
            return false;
        },

        isVersionAvailable: function () {
            wx.ready(function(){
                wx.checkJsApi({
                    jsApiList: ['chooseImage','uploadImage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
                    success: function(res) {
                        // 以键值对的形式返回，可用的api值true，不可用为false
                        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
                        alert(JSON.stringify(res));
                        var data = JSON.stringify(res);
                        if(data.checkResult.chooseImage && data.checkResult.uploadImage){
                            return true;
                        }
                    }
                });
            });
        },

        /**
         * 关闭当前页面
         * @param code 表示是保持对话还是直接结束
         */
        closeWindow: function () {
            wx.closeWindow();
        },

        /**
         * 处理APP返回事件
         */
        handleAppBackEvent: function (timeOut, onTimeOut) {
            if(Globals.isRobot == true){
                NativeAppService.closeWindow();
            }else{
                //如果处于图片放大模式
                if ($("#j-full-img-container").is(":visible")) {
                    ImageClickService.hideFullImg();
                } else {
                    DialogService.confirmDialogEnd();
                }
            }
            setTimeout(function() {
                if (typeof onTimeOut !== "undefined") onTimeOut();
            }, timeOut);
        },

        pushHistory: function() {
            var state = {
                title: "title",
                url: "#"
            };
            window.history.pushState(state, "title", "#");
        },

        registerAppBackEvent: function () {
            window.addEventListener("popstate", function(e) {
                NativeAppService.handleAppBackEvent( 2000, function() {
                    NativeAppService.pushHistory();
                });
            }, false);
        },

        init: function () {
            NativeAppService.pushHistory();
            setTimeout(function () {
                NativeAppService.registerAppBackEvent();
            },300);
        }
    };