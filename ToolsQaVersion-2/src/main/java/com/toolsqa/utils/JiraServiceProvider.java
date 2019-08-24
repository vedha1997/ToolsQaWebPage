package com.toolsqa.utils;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import net.rcarz.jiraclient.Issue.FluentCreate;

public class JiraServiceProvider {
	public JiraClient jira;
	public String project;
	
	public JiraServiceProvider(String username,String password,String jiraurl,String project) {
		BasicCredentials creds = new BasicCredentials(username, password);
		jira = new JiraClient(jiraurl,creds);
		this.project = project;
	}
	
	public void createJiraTicket(String issuetype,String summary,String description,String reporterName) {
		
		try {
			FluentCreate fluentCreate = jira.createIssue(project,issuetype);
			fluentCreate.field(Field.SUMMARY, summary);
			fluentCreate.field(Field.DESCRIPTION, description);
			Issue newIssue = fluentCreate.execute();
			System.out.println("new issue created  "  +  newIssue );

		} catch (JiraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
