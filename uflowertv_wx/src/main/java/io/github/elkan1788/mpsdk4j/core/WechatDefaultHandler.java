package io.github.elkan1788.mpsdk4j.core;

import com.util.commons.ConstantHolder;
import io.github.elkan1788.mpsdk4j.vo.event.*;
import io.github.elkan1788.mpsdk4j.vo.message.*;
import io.github.elkan1788.mpsdk4j.vo.push.SentAllJobEvent;
import io.github.elkan1788.mpsdk4j.vo.push.SentTmlJobEvent;
import org.nutz.lang.Strings;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * 微信消息,事件处理器(实际生产中需要重写)
 * 
 * @author 凡梦星尘(elkan1788@gmail.com)
 * @since 2.0
 */

@Service
public class WechatDefaultHandler implements WechatHandler {

	
    @Override
    public BasicMsg defMsg(BasicMsg msg) {
        TextMsg text_msg = new TextMsg(msg);
        text_msg.setContent(msg.getMsgType());
        return text_msg;
    }

    @Override
    public BasicMsg defEvent(BasicEvent event) {
        TextMsg text_msg = new TextMsg(event);
        text_msg.setContent(Strings.join("\n", event.getEvent(), event.getEventKey()));
        return text_msg;
    }

    @Override
    public BasicMsg text(TextMsg msg) {
        return msg;
    }

    @Override
    public BasicMsg image(ImageMsg msg) {
        return msg;
    }

    @Override
    public BasicMsg voice(VoiceMsg msg) {
        TextMsg text_msg = new TextMsg(msg);
        text_msg.setContent(Strings.join("\n", msg.getMediaId(), msg.getFormat(), msg.getRecognition()));
        return text_msg;
    }

    @Override
    public BasicMsg video(VideoMsg msg) {
        TextMsg text_msg = new TextMsg(msg);
        text_msg.setContent(Strings.join("\n", msg.getMsgType(), msg.getMediaId(), msg.getThumbMediaId()));
        return text_msg;
    }

    @Override
    public BasicMsg shortVideo(VideoMsg msg) {
        TextMsg text_msg = new TextMsg(msg);
        text_msg.setContent(Strings.join("\n", msg.getMsgType(), msg.getMediaId(), msg.getThumbMediaId()));
        return text_msg;
    }

    @Override
    public BasicMsg location(LocationMsg msg) {
        TextMsg text_msg = new TextMsg(msg);
        text_msg.setContent(Strings.join("\n",
                                   msg.getX(),
                                   msg.getY(),
                                   String.valueOf(msg.getScale()),
                                   msg.getLabel()));
        return text_msg;
    }

    @Override
    public BasicMsg link(LinkMsg msg) {
        NewsMsg news_msg = new NewsMsg(msg);
        Article art = new Article();
        art.setTitle(msg.getTitle());
        art.setDescription(msg.getDescription());
        art.setPicUrl("http://j2ee.u.qiniudn.com/mpsdk4j-logo.png-aliassmall");
        art.setUrl(msg.getUrl());
        news_msg.setArticles(Arrays.asList(art));
        return news_msg;
    }

    @Override
    public BasicMsg eClick(MenuEvent event) {
        TextMsg text_msg = new TextMsg(event);
        if("company_js".equals(event.getEventKey())){
    	   text_msg.setContent(ConstantHolder.COMPANY_JS);
        }else if("hello".equals(event.getEventKey())){
        	text_msg.setContent("Hello");
        }else if("robot_reply".equals(event.getEventKey())){
        	text_msg.setContent("Hello");
        }else{
        	text_msg.setContent("不知所云");
        }
        return text_msg;
    }

    @Override
    public void eView(MenuEvent event) {}

    @Override
    public BasicMsg eSub(BasicEvent event) {
        TextMsg text_msg = new TextMsg(event);
        String content = "欢迎关注油菜花微信公众号!";
        text_msg.setContent(content);
        return text_msg;
    }
    
    @Override
    public void eUnSub(BasicEvent event) {}

    @Override
    public BasicMsg eScan(ScanEvent event) {
        TextMsg text_msg = new TextMsg(event);
        text_msg.setContent(event.getEventKey() + event.getTicket());
        return text_msg;
    }

    @Override
    public void eLocation(LocationEvent event) {}

    @Override
    public BasicMsg eScanCodePush(ScanCodeEvent event) {
        TextMsg text_msg = new TextMsg(event);
        text_msg.setContent(Strings.join("\n", event.getEventKey(), event.getScanType(), event.getScanResult()));
        return text_msg;
    }

    @Override
    public BasicMsg eScanCodeWait(ScanCodeEvent event) {
        return this.eScanCodePush(event);
    }

    @Override
    public BasicMsg ePicSysPhoto(SendPhotosEvent event) {
        TextMsg text_msg = new TextMsg(event);
        text_msg.setContent(Strings.join("\n",
                                   event.getEventKey(),
                                   String.valueOf(event.getSendPicsInfo().getCount()),
                                   String.valueOf(event.getSendPicsInfo().getPicList()),
                                   String.valueOf(event.getSendPicsInfo()
                                                     .getPicList()
                                                     .get(0)
                                                     .getPicMd5Sum())));
        return text_msg;
    }

    @Override
    public BasicMsg ePicPhotoOrAlbum(SendPhotosEvent event) {
        return this.ePicSysPhoto(event);
    }

    @Override
    public BasicMsg ePicWeixin(SendPhotosEvent event) {
        return this.ePicSysPhoto(event);
    }

    @Override
    public BasicMsg eLocationSelect(SendLocationInfoEvent event) {
        TextMsg text_msg = new TextMsg(event);
        text_msg.setContent(Strings.join("\n",
                                   event.getLocationX(),
                                   event.getLocationY(),
                                   event.getLabel(),
                                   String.valueOf(event.getScale()),
                                   event.getPoiname()));
        return text_msg;
    }

    @Override
    public void eSentTmplJobFinish(SentTmlJobEvent event) {}

    @Override
    public void eSentAllJobFinish(SentAllJobEvent event) {}

    @Override
    public void eCreateKfSession(CustomServiceEvent event) {}

    @Override
    public void eCloseKfSession(CustomServiceEvent event) {}

    @Override
    public void eSwitchKfSession(CustomServiceEvent event) {}
}
