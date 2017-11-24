package com.niit.SayhiBackend.dao;

import java.util.ArrayList;

import com.niit.SayhiBackend.model.BlogComment;
import com.niit.SayhiBackend.model.Forum;
import com.niit.SayhiBackend.model.ForumComment;

public interface ForumDAO {
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public Forum getForum(int forumId);
	public ArrayList<Forum> getAllForum();
	public boolean approveForum(Forum forum);
	public boolean rejectforum(Forum forum);
	public boolean addForumComment(ForumComment forumcomment);
	public boolean updateForumComment(ForumComment forumcomment);
	public boolean deleteForumComment(ForumComment forumcomment);
	public ForumComment getForumComment(int commentId);
}
