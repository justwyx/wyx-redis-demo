package com.iiasaas.uc.entity.shiro;

/**
 * @Description : TODO 2019/7/16
 * @author : Just wyx
 * @Date : 2019/7/16
 */

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 *
 * @author fengshuonan
 * @date 2016年12月5日 上午10:26:43
 */
public class SupplierShiroUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Deprecated
    private Integer id;

    /**
     * 供应商账户ID
     */
    private Integer supplierUserId;

    /**
     * 供应商编号
     */
    private Integer distributorId;

    /**
     * 供应商name
     */
    private String distributorName;

    /**
     * 商户logo图片
     */
    private String logoImageUrl;

    /**
     * 短信签名值
     */
    protected String smsSignName;

    /**
     * 登录人手机号
     */
    protected String loginUserPhone;


    /**
     * 账号
     */
    private String account;

    private String password;

    private String salt;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 角色集合
     */
    private List<Integer> roleIdList;

    /**
     * 角色名称集合
     */
    private List<String> roleNameList;

    /**
     * @Description : TODO 2019/9/19
     * @param null 入参
     * @Author : Just wyx
     * @Date : 15:09 2019/9/19 
     * @return : 
     */
    private List<String> menuUrlList;

    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 当前登录时间
     */
    private Date currentLoginDate;

    /**
     * 当前登录IP
     */
    private String ip;

    /**
     * 当前登录IP地址
     */
    private String ipAddress;

    /**
     * 上次登录时间
     */
    private Date lastLoginDate;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplierUserId() {
        return supplierUserId;
    }

    public void setSupplierUserId(Integer supplierUserId) {
        this.supplierUserId = supplierUserId;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl;
    }

    public String getSmsSignName() {
        return smsSignName;
    }

    public void setSmsSignName(String smsSignName) {
        this.smsSignName = smsSignName;
    }

    public String getLoginUserPhone() {
        return loginUserPhone;
    }

    public void setLoginUserPhone(String loginUserPhone) {
        this.loginUserPhone = loginUserPhone;
    }




    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }

    public List<String> getMenuUrlList() {
        return menuUrlList;
    }

    public void setMenuUrlList(List<String> menuUrlList) {
        this.menuUrlList = menuUrlList;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCurrentLoginDate() {
        return currentLoginDate;
    }

    public void setCurrentLoginDate(Date currentLoginDate) {
        this.currentLoginDate = currentLoginDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "SupplierShiroUser{" +
                "id=" + id +
                ", supplierUserId=" + supplierUserId +
                ", distributorId=" + distributorId +
                ", distributorName='" + distributorName + '\'' +
                ", logoImageUrl='" + logoImageUrl + '\'' +
                ", smsSignName='" + smsSignName + '\'' +
                ", loginUserPhone='" + loginUserPhone + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleIdList=" + roleIdList +
                ", roleNameList=" + roleNameList +
                ", menuUrlList=" + menuUrlList +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", currentLoginDate=" + currentLoginDate +
                ", ip='" + ip + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }
}