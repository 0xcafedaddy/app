var AjaxService = AjaxService || {};

$.extend(AjaxService, {
    t1: null,   // 记录上一次方法调用的时间,方式iscroll引入的click双击事件
    setScore: function (serviceLogId, score, _this) {
        var scoreDTO = {
            source: Globals.queueResponseInfo.from,
            standardQuestion_id: $("#j-hide-standardQuestionId-"+serviceLogId).val(),
            standardQuestion: $("#j-hide-standardQuestion-"+serviceLogId).val(),
            service_log_id: serviceLogId,
            question: $("#j-hide-question-"+serviceLogId).val(),
            answer: $("#hit-answer-"+serviceLogId).text(),
            from_user: Globals.userInRequestDto.customerId,
            annotation: "",
            satisfaction: score,
            robotValue: Globals.queueResponseInfo.robotValue
        };

        // 移除onclick事件,防止多次触发
        $('#j-answer-envaluation-' + serviceLogId + " a").removeAttr('onclick');

        $.ajax(
            {
                type: 'POST',
                url: "/robot/setScore",
                data: scoreDTO,

                success: function (success) {
                    if (success) {
                        $(_this).addClass('active');
                        $("#j-answer-envaluation-thanks-" + serviceLogId).show();
                        UIService.refreshScroller && UIService.refreshScroller();
                    }
                }
            }
        );
    },
    /**
     * 将机器人答案标记为已读
     * @param relationId
     */
    getAnswer: function (num, questionId) {
        if (AjaxService.t1 == null){
            AjaxService.t1 = new Date().getTime();
        }else{
            var t2 = new Date().getTime();
            if(t2 - AjaxService.t1 < 500){
                AjaxService.t1 = t2;
                return;
            }else{
                AjaxService.t1 = t2;
            }
        }

        // 1. append用户点击的问题内容到聊天记录框
//      var content = $("#j-answer-title-"+questionId).text().trim();
//      if(content.length == 0)return;
//      // 兼容pc和app
//      $("#j-chat-edit-area").text(content);
//      $("#j-chat-edit-area-robot").text(content);

//      UserService.sendMessageToRobot();
    },

    /**
     * 将机器人答案标记为已读
     * @param relationId
     */
    robotAnswerViewed: function (relationId) {
        $.ajax(
            {
                type: 'PUT',
                url: "/robot/robotAnswerViewed/" + relationId,
                headers: {
                    'Accept': 'application/json'
                },

                success: function (success) {
                    if (success) {
                        $('#j-answer-title-' + relationId).removeAttr("onclick");
                    }
                }
            }
        );
    }

});


