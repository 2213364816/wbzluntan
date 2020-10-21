package com.wbzluntan.usermanager.entity;

public class Userinfo {
    private Integer userid;

    private String username;

    private String email;

    private String userpwd;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", username=" + username + ", email=" + email + ", userpwd=" + userpwd
				+ "]";
	}

	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Userinfo(Integer userid, String username, String email, String userpwd) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.userpwd = userpwd;
	}
    
    
}