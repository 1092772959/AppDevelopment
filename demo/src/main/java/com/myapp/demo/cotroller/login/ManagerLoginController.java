package com.myapp.demo.cotroller.login;

/**
 * 管理员登录
 */
import com.myapp.demo.entity.Administer;
import com.myapp.demo.entity.User;
import com.myapp.demo.entity.UserLogin.TokenResponse;
import com.myapp.demo.entity.UserLogin.UserLogin;
import com.myapp.demo.model.Result;
import com.myapp.demo.service.IUserService;
import com.myapp.demo.service.impl.AdministerServiceImpl;
import com.myapp.demo.tool.JwtUtil;
import com.myapp.demo.tool.ResultTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ManagerLoginController {
    private IUserService iUserService;

    private AdministerServiceImpl administerService;

    @Autowired
    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @Autowired
    public void setAdministerService(AdministerServiceImpl administerService) {
        this.administerService = administerService;
    }

    @RequestMapping("/managerLogin")
    public Result ManagerLogin(@RequestParam UserLogin userLogin){
        Administer administer = administerService.findAdministerByAccount(userLogin.getUserId());
        TokenResponse tokenResponse=new TokenResponse();
        if(administer==null || !administer.getPswd().equals(userLogin.getUserPassword())){
            return ResultTool.error("用户名或密码错误");
        }
         //tokenResponse.setIdentity(studentList.get(0).getIdentity().toString());
        tokenResponse.setToken(JwtUtil.createJwt(administer.getId().toString()));
 //        tokenResponse.setUserName(studentList.get(0).getOthers());
        tokenResponse.setUserId(administer.getId().toString());
        return ResultTool.success(tokenResponse);
    }
}
