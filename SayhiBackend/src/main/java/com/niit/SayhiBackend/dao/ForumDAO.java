package com.niit.SayhiBackend.dao;

import java.util.ArrayList;


import com.niit.SayhiBackend.model.Forum;
import com.niit.SayhiBackend.model.ForumComments;

public interface ForumDAO {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public Forum getForum(int forumId);
	public ArrayList<Forum> getAllForum();
	public boolean approveForum(Forum forum);
	public boolean rejectforum(Forum forum);
	public boolean addForumComment(ForumComments forumcomment);
	public boolean updateForumComment(ForumComments forumcomment);
	public boolean deleteForumComment(ForumComments forumcomment);
	public ForumComments getForumComment(int commentId);
	public ArrayList<ForumComments> getAllForumComments(int forumid);

	
}
