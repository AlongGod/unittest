package com.unittest.unittest.bo;

import com.unittest.unittest.model.Admin;
import com.unittest.unittest.util.page.PageView;
import org.springframework.ui.ModelMap;

public interface AdminService {
    public Admin adminLogin(String userName, String passWord);

    public void deleteById(String id);

    public Admin getById(String id);

    public void insert(Admin admin);

    public ModelMap queryAdminMap(PageView pageView, Admin admin);

    public void update(Admin admin);

    public void updatePwd(String passWd, String id);
}
