package com.skcc.cloudz.zcp.portal.alert.channels.vo;

public class ChannelVo {

	private Integer id;
	private String channel;
	private String notifications;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel
	 *            the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the notifications
	 */
	public String getNotifications() {
		return notifications;
	}

	/**
	 * @param notifications
	 *            the notifications to set
	 */
	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

}
