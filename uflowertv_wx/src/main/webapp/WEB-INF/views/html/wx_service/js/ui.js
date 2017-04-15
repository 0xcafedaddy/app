var UIService = UIService || {};

$.extend(UIService,
    {
        /**
         * 将聊天内容下拉到最底部
         */
        scrollTop: function () {
            $('#j-chat-body').scrollTop(999999);
        },

        robotMode: function () {
            $('body').addClass('robot');
            UserService.sendMessage = UserService.sendMessageToRobot;

            //if (typeof NativeAppService !== 'undefined') {
            //    // 在app的title显示转接人工按钮
            //    NativeAppService.showForwardButton();
            //}
        },

        cancelRobotMode: function () {
            $('body').removeClass('robot');
            UserService.sendMessage = UserService.sendMessageToKefu;

            //if (typeof NativeAppService !== 'undefined') {
            //    // 隐藏app右上角的转接人工按钮
            //    NativeAppService.hideForwardButton();
            //}
        },

        /**
         * 根据消息模板为用户创建一条消息的UI
         * @param messageContent 消息内容
         * @param messageId 消息ID
         * @returns {*|jQuery}
         */
        createMessageUiForUser: function (messageContent, messageId) {
            // 判断消息内容是否为图片元素，如果是，则将图片内容包装为可点击的图片
            if (MessageService.isImgDom(messageContent)) {
                messageContent = MessageService.getClickableImgDom(messageContent);
            }
            var messageWrapper = $("#j-template-message-user").clone();
            messageWrapper.find(".chat-message-item-time").html(new Date().Format("yyyy-MM-dd hh:mm:ss"));
            messageWrapper.find(".chat-message-item-content").html(messageContent);
            messageWrapper.find(".chat-message-item").attr("id", "j-user-message-" + messageId);
            messageWrapper.find(".chat-message-item-status-error").attr('click-target-method', "MessageService.doSendMessage(" + messageId + ")");

            return messageWrapper.html();
        },

        /**
         * 根据消息模板为用户创建一条消息的UI
         * @param messageContent 消息内容
         * @param messageId 消息ID
         * @returns {*|jQuery}
         */
        createMessageUiForUserWithDate: function (messageContent, messageId, date) {
            // 判断消息内容是否为图片元素，如果是，则将图片内容包装为可点击的图片
            if (MessageService.isImgDom(messageContent)) {
                messageContent = MessageService.getClickableImgDom(messageContent);
            }
            var messageWrapper = $("#j-template-message-user").clone();
            messageWrapper.find(".chat-message-item-time").html(new Date(date).Format("yyyy-MM-dd hh:mm:ss"));
            messageWrapper.find(".chat-message-item-content").html(messageContent);
            messageWrapper.find(".chat-message-item").attr("id", "j-user-message-" + messageId);
            messageWrapper.find(".chat-message-item-status-error").attr('click-target-method', "MessageService.doSendMessage(" + messageId + ")");
            if(messageId <= 0) {    // 当messageId小于0时，不显示正在发送状态
                messageWrapper.find(".chat-message-item-status")
                    .removeClass("message-status-sending")
                    .removeClass('message-status-error');
            }
            return messageWrapper.html();
        },

        /**
         * 在聊天框中将消息的UI加入进去并且拉动滚动条到最底部
         * @param messageHtml
         */
        appendMessageHtml: function(messageHtml) {
            $("#j-main-chat-container").append(messageHtml);
            $('#j-chat-body').scrollTop(999999);
        },

        init: function() {
        }
    }
);