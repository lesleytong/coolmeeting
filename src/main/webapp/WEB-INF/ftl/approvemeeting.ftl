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
            会议预定 > 会议审批
        </div>
        <table class="listtable">
            <caption>所有待审批会议信息：</caption>
            <tr class="listheader">
                <th>会议id</th>
                <th>会议名称</th>
                <th>参与人数</th>
                <th>会议描述</th>
                <th>操作</th>
            </tr>
            <#if meetings ??>
                <#list meetings as meeting>
                    <tr>
                        <td>${meeting.meetingid}</td>
                        <td>${meeting.meetingname}</td>
                        <td>${meeting.numberofparticipants}</td>
                        <td>${meeting.description}</td>
                        <td>
                            <a type="button" class="clickbutton" href="/admin/updatestatus2?meetingid=${meeting.meetingid}&status=1">通过</a>
                            <a type="button" class="clickbutton" href="/admin/updatestatus2?meetingid=${meeting.meetingid}&status=2">不通过</a>
                        </td>
                    </tr>
                </#list>
            </#if>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
<#--    <img src="/images/footer.png" alt="CoolMeeting"/>-->
</div>
</body>
</html>