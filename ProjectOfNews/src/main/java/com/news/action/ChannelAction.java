package com.news.action;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.news.entity.Channel;
import com.news.service.ChannelService;
import com.opensymphony.xwork2.ModelDriven;
/*
 *  ChannelAction.java
 */
@Controller
public class ChannelAction extends BaseAction implements ModelDriven<Channel>{
	private Channel channel;
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	private String search;
	
     public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	@Resource
	 private  ChannelService channelService;
	public String queryChannel() {
		  this.setMaxCount(channelService.allCount(search));
          this.getRequest().setAttribute("channelList", channelService.queryChannel(getPage(), getPageSize(),search));
		  return SUCCESS;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	}
	public String insertChannel(){
		channelService.insertChannel(channel);
		return "list";
	}
	
	public String deleteChannel(){
		channelService.deleteChannel(channel);
		return "list";
	}
	public String updateChannel(){
		channelService.updateChannel(channel);
		return "list";
		
		
	}
	public Channel getModel() {
		channel =new Channel();
		return channel;
	}
}
