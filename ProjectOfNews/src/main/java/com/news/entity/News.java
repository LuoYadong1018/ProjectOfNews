package com.news.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="t_news")
public class News {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
	private int id;
    @Column
	private String title;
    @ManyToOne
    @JoinColumn(name="chnl_code")
	private Channel channel;
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	@Column
	private String detail;
	@Column
	private String optor;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable=true)
	private Date crtime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable=true,updatable=true)
	private Date uptime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getOptor() {
		return optor;
	}
	public void setOptor(String optor) {
		this.optor = optor;
	}
	public Date getCrtime() {
		return crtime;
	}
	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
}
