<div class="page-sidebar">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">个人中心</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="notifications">最新通知</a></li>
            <li class="sidebar-menuitem active"><a href="mybookings">我的预定</a></li>
            <li class="sidebar-menuitem"><a href="mymeetings">我的会议</a></li>
        </ul>
    </div>
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">用户管理</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="register">用户注册</a></li>
            <#if currentuser?? && (currentuser.role==2)>
                <li class="sidebar-menuitem"><a href="/admin/departments">班级管理</a></li>
                <li class="sidebar-menuitem"><a href="/admin/approveaccount">注册审批</a></li>
                <li class="sidebar-menuitem"><a href="/admin/searchemployees?status=1">搜索用户</a></li>
            </#if>
        </ul>
    </div>
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">会议预定</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="meetingrooms">查看会议室</a></li>
            <li class="sidebar-menuitem"><a href="bookmeeting">预定会议</a></li>
            <#if currentuser?? && (currentuser.role==2)>
                <li class="sidebar-menuitem"><a href="/admin/addmeetingroom">添加会议室</a></li>
                <li class="sidebar-menuitem"><a href="/admin/approvemeeting">会议审批</a></li>
            </#if>
        </ul>
    </div>
</div>