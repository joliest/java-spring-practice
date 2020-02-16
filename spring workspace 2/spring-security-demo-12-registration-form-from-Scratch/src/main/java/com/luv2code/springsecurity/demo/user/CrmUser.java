package com.luv2code.springsecurity.demo.user;

@FieldMatch.List({
	@FieldMatch(first = "password", second = "matchingPassword", 
			message = "The password fields must match")
})
public class CrmUser {

}
