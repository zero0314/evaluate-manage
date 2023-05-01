package com.zero314.evaluatemanage.config;

import cn.dev33.satoken.exception.*;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author yh
 */
@RestControllerAdvice
public class GlobalException {

    /**
     * 拦截：未登录异常
     *
     * @param e NotLoginException
     * @return SaResult
     */
    @ExceptionHandler(NotLoginException.class)
    public SaResult handlerException(NotLoginException e) {
        // 返回给前端
        return SaResult.error(e.getMessage());
    }

    /**
     * 拦截：缺少权限异常
     *
     * @param e NotPermissionException
     * @return SaResult
     */
    @ExceptionHandler(NotPermissionException.class)
    public SaResult handlerException(NotPermissionException e) {
        return SaResult.error("缺少权限：" + e.getPermission());
    }

    /**
     * 拦截：缺少角色异常
     *
     * @param e NotRoleException
     * @return SaResult
     */
    @ExceptionHandler(NotRoleException.class)
    public SaResult handlerException(NotRoleException e) {
        return SaResult.error("缺少角色：" + e.getRole());
    }

    /**
     * 拦截：二级认证校验失败异常
     *
     * @param e NotSafeException
     * @return SaResult
     */
    @ExceptionHandler(NotSafeException.class)
    public SaResult handlerException(NotSafeException e) {
        return SaResult.error("二级认证校验失败：" + e.getService());
    }

    /**
     * 拦截：服务封禁异常
     *
     * @param e DisableServiceException
     * @return SaResult
     */
    @ExceptionHandler(DisableServiceException.class)
    public SaResult handlerException(DisableServiceException e) {
        return SaResult.error("当前账号 " + e.getService() + " 服务已被封禁 (level=" + e.getLevel() + ")：" + e.getDisableTime() + "秒后解封");
    }

    /**
     * 拦截：HttpBasic 校验失败异常
     *
     * @param e NotBasicAuthException
     * @return SaResult
     */
    @ExceptionHandler(NotBasicAuthException.class)
    public SaResult handlerException(NotBasicAuthException e) {
        return SaResult.error(e.getMessage());
    }

    /**
     * 拦截：参数校验异常
     *
     * @param e IllegalArgumentException
     * @return SaResult
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public SaResult handlerException(IllegalArgumentException e) {
        return SaResult.error(e.getMessage());
    }

    /**
     * 拦截：其它所有异常
     *
     * @param e Exception
     * @return SaResult
     */
    @ExceptionHandler(Exception.class)
    public SaResult handlerException(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }

}

