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
			                      "<br>" +
			                      "<font size=\"-1\"> <h3>Video Url: </h3>"+
								  "localhost:8080/video/stream/videoExtension/videoName"+
							      "- <a href=\"/video/stream/mp4/toystory\">Example</a>"+
			                      "<br> <H3>Video Folder: </h3>"+
			                      "C:/Users/Root/Desktop/FolderName/AppFolderName/target/classes/videoFolder"+
			                      "</font>" +
			                      "<br> <h2>Files</h2>"+
							      "<br><form action=\"/refresh\">\n" +
							      "<input type=\"submit\" value=\"Get/Refresh Folder Items\" /></form> </html>";

	String indexElementsForReturn = element1ForReturn;
	String folderItems = "";

	//indexe girildiginde surekli islem tekrarlamasin diye var.
	@GetMapping("/refresh")
	public String refresh()
	{
		System.out.println("Page::Refresh");
		folderItems = "";


		ListFolderItems listFolderItems = new ListFolderItems();
		/* Before
		for (Object veri:listFolderItems.getFiles()) {
			folderItems = folderItems +"<br>"+ veri;
		}
		*/

		//After
		for (Object veri:listFolderItems.itemsToLink()) {
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