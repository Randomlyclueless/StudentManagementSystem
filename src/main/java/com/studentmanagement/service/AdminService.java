package com.studentmanagement.service;

import com.studentmanagement.dao.AdminDao;

public class AdminService {

    private final AdminDao adminDao;

    public AdminService() {
        adminDao = new AdminDao();
    }

    public boolean login(String username, String password) {
        return adminDao.login(username, password);
    }
}