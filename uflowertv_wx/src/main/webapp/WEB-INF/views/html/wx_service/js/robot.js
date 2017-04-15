/**
 * Created by hantian on 16/2/26.
 */

var RobotService = RobotService || {};


$.extend(RobotService, {
    /**
     * 根据默认问题获取常用问题推荐
     */
    getRobotGuideAnswer: function () {
        // 1. 获取机器人默认问题,但不展示出发送消息框
        var content = Globals.queueResponseInfo.robotQuestion;
        if(!content || content.length == 0)return;
        var messageId = MessageService.Field.idUserMessage;

        // 2. ajax发送问题
        var message = {
            content: content,    // 使用questionId获取答案
            dialogId: Globals.userInRequestDto.dialogId,
            robotDialogId: Globals.queueResponseInfo.robotDialogId,
            robotValue: Globals.queueResponseInfo.robotValue,
            manualDialogId:Globals.queueResponseInfo.manualDialogId,
            userType: Globals.queueResponseInfo.userType,
            consultId: Globals.userInRequestDto.consultId,
            source: Globals.queueResponseInfo.from,
            messageId: messageId,
            customerId: Globals.userInRequestDto.customerId
        };

        RobotService.sendSystemMessageToRobot(message, messageId);
    },

    /**
     * 发送默认问题请求,该请求为非用户主动发出,不创建机器人对话
     * 用于单纯获取答案,不计入用户对话
     */
    sendSystemMessageToRobot: function(data, messageId) {
        $.ajax({
                type: "GET",
                url: "/robot/systemQuestion",
                data: data,
                error: function () {
                    AjaxService.handleError("获取导航问题失败");
                },
                success: function (resultData) {
                    // 将回答默认问题的机器人类别保存,用于服务此次机器人对话
                    var robotValue = $(resultData).filter('.j-robot-value').text();
                    var robotKey = $(resultData).filter('.j-robot-key').text();
                    Globals.queueResponseInfo.robotValue = robotValue;
                    Globals.userInRequestDto.robotValue = robotValue;
                    Globals.queueResponseInfo.robotKey = robotKey;
                    Globals.userInRequestDto.robotKey = robotKey;

                    var msgWrapper = {body: JSON.stringify({content: resultData})};
                    MessageService.processKefuTextMessage(msgWrapper, false);
                }
            }
        );
    }

});
