<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
        <script src="/My97DatePicker/WdatePicker.js"></script>
        <style type="text/css">
        </style>
    </head>
    <body>
    <#include 'top.ftl'>
        </div>
        <div class="page-body">
            <#include 'leftMenu.ftl'>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的预定
                </div>
                <table class="listtable">
                    <caption>我预定的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>参会人数</th>
                        <th>会议描述</th>
                    </tr>
                    <#if mbs ??>
                        <#list mbs as mb>
                            <tr>
                                <td>${mb.meetingname}</td>
                                <td>${mb.numberofparticipants}</td>
                                <td>${mb.description}</td>
                            </tr>
                        </#list>
                    </#if>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
<#--            <img src="/images/footer.png" alt="CoolMeeting"/>-->
        </div>
    </body>
</html>