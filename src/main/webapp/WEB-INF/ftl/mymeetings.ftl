<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
    <#include 'top.ftl'>
        <div class="page-body">
            <#include 'leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的会议
                </div>
                <table class="listtable">
                    <caption>我将参加的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>参会人数</th>
                        <th>会议描述</th>
                    </tr>
                    <#if mes ??>
                        <#list mes as me>
                            <tr>
                                <td>${me.meetingname}</td>
                                <td>${me.numberofparticipants}</td>
                                <td>${me.description}</td>
                            </tr>
                        </#list>
                    </#if>
                    <tr>
                        <td>软件工程讨论</td>
                        <td>2</td>
                        <td>会议管理系统的讨论</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
        </div>
    </body>
</html>