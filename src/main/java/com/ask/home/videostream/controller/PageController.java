package com.ask.home.videostream.controller;

import com.ask.home.videostream.utils.ListFolderItems;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/", method = RequestMethod.GET)
public class PageController {
	//ListFolderItems listFolderItems;

	public PageController() {
     
    }
	
	String element1ForReturn = "<html> <h1> Miller's Streaming </h1>"+
			                      "<br> <h2>Video Url</h2>"+
								  "<br> localhost:8080/video/stream/videoExtension/videoName"+
							      "<br> <a href=\"/video/stream/mp4/toystory\">Example</a>"+
			                      "<br> <H2>Video Folder</h2>"+
			                      "<br> C:/Users/Root/Desktop/FolderName/AppFolderName/target/classes/videoFolder"+
			                      "<br> <h2>Files</h2>"+
							      "<br><form action=\"/refresh\">\n" +
							      "<input type=\"submit\" value=\"Get/Refresh Folder Items\" /></form> </html>";

	String indexElementsForReturn = element1ForReturn;
	String folderItems = "";

	@GetMapping("/refresh")
	public String refresh()
	{
		System.out.println("Page::Refresh");
		folderItems = "";


		ListFolderItems listFolderItems = new ListFolderItems();
		for (Object veri:listFolderItems.getFiles()) {
			folderItems = folderItems +"<br>"+ veri;
		}
		return "<a href=\"#\" onclick=\"javascript:window.history.back(-1);return false;\">Loading..</a>"+
				"<meta http-equiv=\"refresh\" content=\"0; URL=/\" /\">";
	}

	@GetMapping("/")
	public String index()
	{
		System.out.println("Page::Index");



		return indexElementsForReturn + folderItems;
	}


}