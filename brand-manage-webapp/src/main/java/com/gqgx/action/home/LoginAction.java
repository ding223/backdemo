/**
 * 描述:<p></p>
 * @Title: HomeAction.java
 * @Package com.gqgx.action.common
 * 
 * @author weihongjun
 * @date 2016年11月30日 下午4:38:54
*/


package com.gqgx.action.home;

import com.gqgx.common.entity.SysUser;
import com.gqgx.domain.RequestResult;
import com.gqgx.domain.RequestResult.CODE;
import nl.captcha.Captcha;
import nl.captcha.backgrounds.FlatColorBackgroundProducer;
import nl.captcha.noise.StraightLineNoiseProducer;
import nl.captcha.text.producer.DefaultTextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:<p></p>
 * @ClassName: HomeAction
 * @author weihongjun
 * @date 2016年11月30日 下午4:38:54
 *
 */
@Controller
public class LoginAction
{
    
    private Logger logger = LoggerFactory.getLogger(LoginAction.class);
    
    /**
      * 描述:<p>登录页面跳转</P>
      *
      * @author weihongjun
      * @param model
      * @return
      * @return ModelAndView
      * @throws
    */
    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public ModelAndView loginForm(Model model)
    {
        return new ModelAndView("/login");
    }
      
    /**
      * 描述:<p>用户登录</P>
      *
      * @author weihongjun
      * @param user
      * @return
      * @return String
      * @throws
    */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RequestResult login(SysUser user,String vcode, HttpServletRequest request, HttpServletResponse response)
    {
        RequestResult result = new RequestResult();
        try
        {
            //登录时执行RoleShiro.doGetAuthenticationInfo方法
            // 使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
            SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getAccountName(), user.getPassWord() ));
            result.setCode(CODE.SUCCESS.getCode());
            return result;
        }
        catch (AuthenticationException e)
        {
            logger.error("===========用户登录认证失败：==============", e);
            result.setMsg(e.getMessage());
            result.setCode(CODE.FAIL.getCode());
            return result;
        }
    }
      
    /**
      * 描述:<p>退出登录</P>
      *
      * @author weihongjun
      * @param redirectAttributes
      * @return
      * @return String
      * @throws
    */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes)
    {
        // 使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:/loginForm";
    }
      
    /**
      * 描述:<p>没有权限页面</P>
      *
      * @author weihongjun
      * @return
      * @return String
      * @throws
    */
    @RequestMapping("/403")
    public String unauthorizedRole()
    {
        //throw new AuthenticationException("对不起，您没有此操作权限！");
        return "/403";
    }
    
    @RequestMapping("/building")
    public ModelAndView building()
    {
        return new ModelAndView("/building");
    }
    
    /**
     * 验证码生成
     * 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/vcode")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        List<Font> fontList = new ArrayList<Font>();
        fontList.add(new Font("Arial", Font.HANGING_BASELINE, 23));// 可以设置斜体之类的
        fontList.add(new Font("Courier", Font.ITALIC, 23));
        
        Captcha captcha =
            new Captcha.Builder(70, 30).addBackground(new FlatColorBackgroundProducer(Color.lightGray))
                .addNoise(new StraightLineNoiseProducer(Color.CYAN, 2))
                .addText(new DefaultTextProducer(),
                    new DefaultWordRenderer(new Color(0,255,255), fontList))
                .build();

        // 设置二维码
        final HttpSession session = request.getSession();
        session.setAttribute("vcode", captcha.getAnswer());
        
        response.setContentType("image/jpg");
        response.setHeader("Cache-Control", "no-store");
        ImageIO.write(captcha.getImage(), "jpg", response.getOutputStream());
        
        response.getOutputStream().flush();
    }
}
