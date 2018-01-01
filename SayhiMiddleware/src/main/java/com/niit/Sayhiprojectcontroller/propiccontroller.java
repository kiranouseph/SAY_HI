package com.niit.Sayhiprojectcontroller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.SayhiBackend.dao.UsersDAO;
import com.niit.SayhiBackend.model.Users;

@Controller
public class propiccontroller {
@Autowired
	UsersDAO userDAO;








}
