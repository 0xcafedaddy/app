package com.uflowertv.util.sftp;

import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.uflowertv.commons.BaseService;
import com.uflowertv.util.ConstantHolder;

public class SFTPChannel extends BaseService{
    Session session = null;
    Channel channel = null;

    public ChannelSftp getChannel(int timeout) throws JSchException {
    	
        JSch jsch = new JSch(); // 创建JSch对象
        session = jsch.getSession(ConstantHolder.SFTP_REQ_USERNAME, ConstantHolder.SFTP_REQ_HOST, ConstantHolder.SFTP_DEFAULT_PORT); // 根据用户名，主机ip，端口获取一个Session对象
        session.setPassword(ConstantHolder.SFTP_REQ_PASSWORD); // 设置密码
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        log.debug("Session connected.");

        log.debug("Opening Channel.");
        channel = session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        return (ChannelSftp) channel;
    }

    public void closeChannel() throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }
}