<%@ page import="com.example.lunchbox.model.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Khizar
  Date: 2/17/2018
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="description" content="">
    <meta name="keywords" content="coco bootstrap template, coco admin, bootstrap,admin template, bootstrap admin,">
    <meta name="author" content="Huban Creative">

    <!-- Base Css Files -->
    <link href="${pageContext.request.contextPath}/assets/libs/jqueryui/ui-lightness/jquery-ui-1.10.4.custom.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/fontello/css/fontello.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/animate-css/animate.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/nifty-modal/css/component.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/magnific-popup/magnific-popup.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/ios7-switch/ios7-switch.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/pace/pace.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/sortable/sortable-theme-bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/bootstrap-datepicker/css/datepicker.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/assets/libs/jquery-icheck/skins/all.css" rel="stylesheet" />
    <!-- Code Highlighter for Demo -->
    <link href="${pageContext.request.contextPath}/assets/libs/prettify/github.css" rel="stylesheet" />

    <!-- Extra CSS Libraries Start -->
    <link href="${pageContext.request.contextPath}/assets/libs/rickshaw/rickshaw.min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/libs/morrischart/morris.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/libs/jquery-jvectormap/css/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/libs/jquery-clock/clock.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/libs/bootstrap-calendar/css/bic_calendar.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/libs/sortable/sortable-theme-bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/libs/jquery-weather/simpleweather.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/libs/bootstrap-xeditable/css/bootstrap-editable.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
    <!-- Extra CSS Libraries End -->
    <link href="${pageContext.request.contextPath}/assets/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/img/favicon.ico">
    <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/assets/img/apple-touch-icon.png" />
    <link rel="apple-touch-icon" sizes="57x57" href="${pageContext.request.contextPath}/assets/img/apple-touch-icon-57x57.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/assets/img/apple-touch-icon-72x72.png" />
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/assets/img/apple-touch-icon-76x76.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/assets/img/apple-touch-icon-114x114.png" />
    <link rel="apple-touch-icon" sizes="120x120" href="${pageContext.request.contextPath}/assets/img/apple-touch-icon-120x120.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/assets/img/apple-touch-icon-144x144.png" />
    <link rel="apple-touch-icon" sizes="152x152" href="${pageContext.request.contextPath}/assets/img/apple-touch-icon-152x152.png" />
</head>
<body class="fixed-left">
<!-- Modal Start -->
<!-- Modal Task Progress -->
<div class="md-modal md-3d-flip-vertical" id="task-progress">
    <div class="md-content">
        <h3><strong>Task Progress</strong> Information</h3>
        <div>
            <p>CLEANING BUGS</p>
            <div class="progress progress-xs for-modal">
                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                    <span class="sr-only">80&#37; Complete</span>
                </div>
            </div>
            <p>POSTING SOME STUFF</p>
            <div class="progress progress-xs for-modal">
                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 65%">
                    <span class="sr-only">65&#37; Complete</span>
                </div>
            </div>
            <p>BACKUP DATA FROM SERVER</p>
            <div class="progress progress-xs for-modal">
                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 95%">
                    <span class="sr-only">95&#37; Complete</span>
                </div>
            </div>
            <p>RE-DESIGNING WEB APPLICATION</p>
            <div class="progress progress-xs for-modal">
                <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                    <span class="sr-only">100&#37; Complete</span>
                </div>
            </div>
            <p class="text-center">
                <button class="btn btn-danger btn-sm md-close">Close</button>
            </p>
        </div>
    </div>
</div>

<!-- Modal Logout
<div class="md-modal md-just-me" id="logout-modal">
    <div class="md-content">
        <h3><strong>Logout</strong> Confirmation</h3>
        <div>
            <p class="text-center">Are you sure want to logout from this awesome system?</p>
            <p class="text-center">
                <button class="btn btn-danger md-close">Nope!</button>
                <a href="localhost:8080" class="btn btn-success md-close">Yeah, I'm sure</a>
            </p>
        </div>
    </div>
</div>         Modal End --><%@include file="includes/logout-modal.jsp" %>
<!-- Begin page -->
<div id="wrapper">

    <!-- Top Bar Start -->
         <%@include file="includes/right-panel.jsp" %>
    <!-- Top Bar End -->
    <!-- include  Left Sidebar Start -->
    <%@include file="includes/left-panel.jsp" %>
    <!--include Left Sidebar End -->

    <!-- Right Sidebar Start -->
    <div class="right side-menu">
        <ul class="nav nav-tabs nav-justified" id="right-tabs">
            <li class="active"><a href="#feed" data-toggle="tab" title="Live Feed"><i class="icon-rss-2"></i></a></li>
            <li><a href="#connect" data-toggle="tab" title="Chat"><i class="icon-chat"></i></a></li>
            <li><a href="#settings" data-toggle="tab" title="Preferences"><i class="icon-wrench"></i></a></li>
        </ul>
        <div class="clearfix"></div>
        <div class="tab-content">
            <div class="tab-pane active" id="feed">
                <div class="tab-inner slimscroller">
                    <div class="search-right">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <div class="right-toolbar">
                        <a href="javascript:;" class="pull-right">Settings <i class="icon-cog"></i></a>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="panel-group" id="collapse">
                        <div class="panel panel-default">
                            <div class="panel-heading bg-orange-1">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#rnotifications">
                                        <i class="icon-bell-2"></i> Notifications
                                        <span class="label bg-darkblue-1 pull-right">4</span>
                                    </a>
                                </h4>
                            </div>
                            <div id="rnotifications" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <ul class="list-unstyled" id="notification-list">
                                        <li><a href="javascript:;"><span class="icon-wrapper"><i class="icon-video"></i></span> 1 Video Uploaded <span class="muted">12 minutes ago</span></a></li>
                                        <li><a href="javascript:;"><span class="icon-wrapper"><i class="icon-users-1"></i></span> 3 Users signed up <span class="muted">16 minutes ago</span></a></li>
                                        <li><a href="javascript:;"><span class="icon-wrapper"><i class="icon-picture-1"></i></span> 1 Video Uploaded <span class="muted">12 minutes ago</span></a></li>
                                        <li><a href="javascript:;"><span class="icon-wrapper"><i class="icon-hourglass-1"></i></span> Deadline for 1 project <span class="muted">12 minutes ago</span></a></li>
                                    </ul>
                                    <a class="btn btn-block btn-sm btn-warning">See all notifications</a>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading bg-green-3">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#remails">
                                        <i class="icon-mail"></i> E-mails
                                        <span class="label bg-darkblue-1 pull-right">3</span>
                                    </a>
                                </h4>
                            </div>
                            <div id="remails" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <ul class="list-unstyled" id="inbox-list">
                                        <li><a href="javascript:;"><span class="sender"><i class="icon-star text-yellow-2"></i> Kim Wilde</span> <span class="datetime">6 mins ago</span>
                                            <span class="title">You keep me hangin on</span>
                                            <span class="content">Where are you? I am waiting for 3 hours in the restaurant. I ate 3 hamburgers.</span>
                                        </a></li>
                                        <li><a href="javascript:;"><span class="sender">Tyler Durden</span> <span class="datetime">13 hours ago</span>
                                            <span class="title">Buy some soap from market before</span>
                                            <span class="content">We are crowded here. We need some more soap at home. Buy some before you come home.</span>
                                        </a></li>
                                        <li><a href="javascript:;"><span class="sender">John Bonomo</span> <span class="datetime">Yesterday</span>
                                            <span class="title">Late delivery</span>
                                            <span class="content">Hello, I ordered 15 box of viagra for a friend of mine but he still hasn't receive them.</span>
                                        </a></li>
                                    </ul>
                                    <a class="btn btn-block btn-sm btn-primary">Go to inbox</a>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading bg-blue-1">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#rupdates">
                                        <i class="icon-signal-2"></i> Updates
                                        <span class="label bg-darkblue-1 pull-right">5</span>
                                    </a>
                                </h4>
                            </div>
                            <div id="rupdates" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <ul class="list-unstyled" id="updates-list">
                                        <li><a href="javascript:;"><span class="icon-wrapper bg-green-1"><i class="icon-comment-1"></i></span> <b>David Guetta</b> came online <abbr title="15 seconds ago">just now</abbr>.</a></li>
                                        <li><a href="javascript:;"><span class="icon-wrapper bg-red-1"><i class="icon-user-3"></i></span> <b>Katy Perry</b> updated her profile <abbr title="4 mins ago">4 mins ago</abbr>.</a></li>
                                        <li><a href="javascript:;"><span class="icon-wrapper bg-blue-1"><i class="icon-twitter-2"></i></span> <b>4 tweets posted</b> with cronjob <abbr title="22 mins ago">22 mins ago</abbr>.</a></li>
                                        <li><a href="javascript:;"><span class="icon-wrapper bg-orange-3"><i class="icon-water"></i></span> <b>Adele</b> set fire to the rain <abbr title="43 mins ago">43 mins ago</abbr>.</a></li>
                                        <li><a href="javascript:;"><span class="icon-wrapper bg-pink-2"><i class="icon-heart-broken"></i></span> <b>Taylor Swift</b> learned that you are trouble <abbr title="3 hours ago">3 days ago</abbr>.</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane" id="connect">
                <div class="tab-inner slimscroller">
                    <div class="search-right">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <div class="panel-group" id="collapse">
                        <div class="panel panel-default" id="chat-panel">
                            <div class="panel-heading bg-darkblue-2">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" href="#chat-coll">
                                        <i class="icon-briefcase-1"></i> Colleagues
                                        <span class="label bg-darkblue-1 pull-right">14</span>
                                    </a>
                                </h4>
                            </div>
                            <div id="chat-coll" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <ul class="list-unstyled" id="chat-list">
                                        <li><a href="javascript:;" class="online"><span class="chat-user-avatar"><img src="images/users/chat/1.jpg"></span> <span class="chat-user-name">Dorothy Simons</span><span class="chat-user-msg">I wish I was a bird in the sky</span></a></li>
                                        <li><a href="javascript:;" class="online"><span class="chat-user-avatar"><img src="images/users/chat/2.jpg"></span> <span class="chat-user-name">John Malkovich</span><span class="chat-user-msg">You were the traitor</span></a></li>
                                        <li><a href="javascript:;" class="online"><span class="chat-user-avatar"><img src="images/users/chat/3.jpg"></span> <span class="chat-user-name">Jessica Simons</span><span class="chat-user-msg">Where is my mind</span></a></li>
                                        <li><a href="javascript:;" class="away"><span class="chat-user-avatar"><img src="images/users/chat/4.jpg"></span> <span class="chat-user-name">Jack Stallman</span><span class="chat-user-msg">Away since 13:32</span></a></li>
                                        <li><a href="javascript:;" class="offline"><span class="chat-user-avatar"><img src="images/users/chat/5.jpg"></span> <span class="chat-user-name">Neil Armstrong</span><span class="chat-user-msg" title="I am flying to the moon and back">I am flying to the moon and back</span></a></li>
                                        <li><a href="javascript:;" class="offline"><span class="chat-user-avatar"><img src="images/users/chat/6.jpg"></span> <span class="chat-user-name">Hollywood Studios</span><span class="chat-user-msg">Yes he definitely is!</span></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default" id="chat-panel">
                            <div class="panel-heading bg-darkblue-2">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                        <i class="icon-heart-3"></i> Friends
                                        <span class="label bg-darkblue-1 pull-right">3</span>
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseTwo" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <ul class="list-unstyled" id="chat-list">
                                        <li><a href="javascript:;" class="online"><span class="chat-user-avatar"><img src="images/users/chat/1.jpg"></span> <span class="chat-user-name">Dorothy Simons</span><span class="chat-user-msg">I wish I was a bird in the sky</span></a></li>
                                        <li><a href="javascript:;" class="online"><span class="chat-user-avatar"><img src="images/users/chat/2.jpg"></span> <span class="chat-user-name">John Malkovich</span><span class="chat-user-msg">You were the traitor</span></a></li>
                                        <li><a href="javascript:;" class="online"><span class="chat-user-avatar"><img src="images/users/chat/3.jpg"></span> <span class="chat-user-name">Jessica Simons</span><span class="chat-user-msg" title="Eminem - The Monster ft. Rihanna"><i class="icon-play"></i> Eminem - The Monster ft. Rihanna</span></a></li>
                                        <li><a href="javascript:;" class="away"><span class="chat-user-avatar"><img src="images/users/chat/4.jpg"></span> <span class="chat-user-name">Jack Stallman</span><span class="chat-user-msg">Away since 13:32</span></a></li>
                                        <li><a href="javascript:;" class="offline"><span class="chat-user-avatar"><img src="images/users/chat/5.jpg"></span> <span class="chat-user-name">Neil Armstrong</span><span class="chat-user-msg" title="I am flying to the moon and back">I am flying to the moon and back</span></a></li>
                                        <li><a href="javascript:;" class="offline"><span class="chat-user-avatar"><img src="images/users/chat/6.jpg"></span> <span class="chat-user-name">Hollywood Studios</span><span class="chat-user-msg">Yes he definitely is!</span></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="tab-pane" id="settings">
                <div class="tab-inner slimscroller">
                    <div class="col-sm-12">
                        <h3>Preferences</h3>
                        <div class="row">
                            <div class="col-xs-8">
                                Live data updates
                            </div>
                            <div class="col-xs-4">
                                <input type="checkbox" class="ios-switch ios-switch-success ios-switch-sm" checked />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-8">
                                Live feeds
                            </div>
                            <div class="col-xs-4">
                                <input type="checkbox" class="ios-switch ios-switch-success ios-switch-sm" checked />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-8">
                                Sync data to cloud
                            </div>
                            <div class="col-xs-4">
                                <input type="checkbox" class="ios-switch ios-switch-success ios-switch-sm" checked />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-8">
                                Keep activity record
                            </div>
                            <div class="col-xs-4">
                                <input type="checkbox" class="ios-switch ios-switch-danger ios-switch-sm" checked />
                            </div>
                        </div>
                        <h4>Other Settings</h4>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="checkboxw"><input type="checkbox" checked> Autosave settings</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <label class="checkboxw"><input type="checkbox"> Always online</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Right Sidebar End -->
    <!-- Start right content -->
    <div class="content-page">
        <!-- ============================================================== -->
        <!-- Start Content here -->
        <!-- ============================================================== -->

        <!--Start :: add admin form -->

        <div class="row">
            <div class="col-md-12">

                <div class="widget">
                    <div class="widget-header transparent">
                        <h2><strong>Customer</strong> Registeration Form</h2>
                        <div class="additional-btn">
                            <a href="#" class="hidden reload"><i class="icon-ccw-1"></i></a>
                            <a href="#" class="widget-toggle"><i class="icon-down-open-2"></i></a>
                            <a href="#" class="widget-close"><i class="icon-cancel-3"></i></a>
                        </div>
                    </div>
                    <% Customer data = (Customer) request.getAttribute("customerDetail"); %>

                    <input type="hidden" id="rowId" name="rowId" value="<%= (data != null ?data.getCustomerId():"") %>" >
                    <div class="widget-content padding">
                        <form class="form-horizontal" role="form" action="customer-listing.html" id="form">
                            <div class="form-group">
                                <label for="inp-customer-name" class="col-sm-2 control-label">Full Name</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="inp-customer-name" placeholder="Name"  value="<%= (data != null ?data.getCustomerName():"") %>" required>
                                    <div id="errorName" style="color:#ff3351;display:none">*Please enter name</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inp-customer-email" class="col-sm-2 control-label">Email Address</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="inp-customer-email" placeholder="Email Address"  value="<%= (data != null ?data.getCustomerEmail():"") %>" required>
                                    <div id="errorEmail" style="color:#ff3351;display:none">*Please enter valid Email</div>
                                </div>
                            </div>
                            <div class="form-group" <%= (data != null ?"style='display:none'":"") %>>
                                <label for="inp-customer-pass" class="col-sm-2 control-label">Password</label>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control" id="inp-customer-pass" placeholder="Password"  value="<%= (data != null ?data.getCustomerPassword():"") %>" required>
                                    <div id="errorpassword" style="color:#ff3351;display:none;display:none">*Please enter password</div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inp-customer-cnic" class="col-sm-2 control-label">Cnic</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="inp-customer-cnic" placeholder="cnic"  value="<%= (data != null ?data.getCustomerNic():"") %>" required>
                                    <div id="errorcnic" style="color:#ff3351;display:none;display:none">*Please enter valid cnic</div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inp-customer-phoneNum" class="col-sm-2 control-label">Phone Number</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="inp-customer-phoneNum" placeholder="phone number"  value="<%= (data != null ?data.getCustomerPhoneNumber():"") %>" required>
                                    <div id="errorphnum" style="color:#ff3351;display:none;display:none">*Please enter contact number</div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inp-customer-address" class="col-sm-2 control-label">Address</label>
                                <div class="col-sm-6">
                                    <textarea id="inp-customer-address" col="12" row="5" class="form-control" placeholder="Enter Address"   required><%= (data != null ?data.getCustomerAddressId().getAddress():"") %></textarea>
                                    <div id="erroraddress" style="color:#ff3351;display:none;display:none">*Please specify Address</div>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="inp-customer-status">Status</label>
                                <div class="col-sm-5">
                                    <select id="inp-customer-status" class="form-control" required>
                                        <option value="1" <%= (data != null && data.getCustomerAccessType() == 1?"selected":"") %> >Active</option>
                                        <option value="2" <%= (data != null && data.getCustomerAccessType() == 2?"selected":"") %>>DeActive</option>
                                        <option value="3" <%= (data != null && data.getCustomerAccessType() == 3?"selected":"") %>>Suspended</option>
                                    </select>
                                    <div id="errorrole" style="color:#ff3351;display:none;display:none">*Please select Access Type</div>
                                </div>
                            </div>


                            <div class="form-group" style='display:none'>
                                <label class="col-sm-2 control-label">Upload Image</label>
                                <div class="col-sm-10">
                                    <input type="file" class="btn btn-default" title="Select file">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="button" class="form-control" id="btn-add-detail" value="submit" style="background-color:#68C39F;color:#FFFFFF;font-size:16px;width:50%;margin:auto;display:block;border:0;border-radius:16px"/>
                                    <div id="error" style="color:#ff3351;display:none;display:none">Not added error occured</div>

                                </div>
                            </div>
                            <div id="Message" style="color:green;display:none">Please enter a valid password</div>

                        </form>
                    </div>

                </div>
            </div>

        </div>



        <!--end :: add admin form -->

        <!-- Footer Start -->
       <%@include file="includes/footer.jsp" %>
        <!-- Footer End -->
    </div>
    <!-- ============================================================== -->
    <!-- End content here -->
    <!-- ============================================================== -->

</div>
<!-- End right content -->

</div>
<div id="contextMenu" class="dropdown clearfix">
    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu" style="display:block;position:static;margin-bottom:5px;">
        <li><a tabindex="-1" href="javascript:;" data-priority="high"><i class="fa fa-circle-o text-red-1"></i> High Priority</a></li>
        <li><a tabindex="-1" href="javascript:;" data-priority="medium"><i class="fa fa-circle-o text-orange-3"></i> Medium Priority</a></li>
        <li><a tabindex="-1" href="javascript:;" data-priority="low"><i class="fa fa-circle-o text-yellow-1"></i> Low Priority</a></li>
        <li><a tabindex="-1" href="javascript:;" data-priority="none"><i class="fa fa-circle-o text-lightblue-1"></i> None</a></li>
    </ul>
</div>
<!-- End of page -->
<!-- the overlay modal element -->
<div class="md-overlay"></div>
<!-- End of eoverlay modal -->
<script>
    var resizefunc = [];



</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/assets/libs/jquery/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jqueryui/jquery-ui-1.10.4.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-ui-touch/jquery.ui.touch-punch.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-detectmobile/detect.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-animate-numbers/jquery.animateNumbers.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/ios7-switch/ios7.switch.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-blockui/jquery.blockUI.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/bootstrap-bootbox/bootbox.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-slimscroll/jquery.slimscroll.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-sparkline/jquery-sparkline.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/nifty-modal/js/classie.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/nifty-modal/js/modalEffects.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/sortable/sortable.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/bootstrap-fileinput/bootstrap.file-input.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/bootstrap-select/bootstrap-select.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/bootstrap-select2/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/magnific-popup/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/pace/pace.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-icheck/icheck.min.js"></script>

<!-- Demo Specific JS Libraries -->
<script src="${pageContext.request.contextPath}/assets/libs/prettify/prettify.js"></script>

<script src="${pageContext.request.contextPath}/assets/js/init.js"></script>
<!-- Page Specific JS Libraries -->
<script src="${pageContext.request.contextPath}/assets/libs/d3/d3.v3.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/rickshaw/rickshaw.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/morrischart/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-jvectormap/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-jvectormap/js/jquery-jvectormap-us-aea-en.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-clock/clock.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-easypiechart/jquery.easypiechart.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/jquery-weather/jquery.simpleWeather-2.6.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/bootstrap-xeditable/js/bootstrap-editable.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/libs/bootstrap-calendar/js/bic_calendar.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/apps/calculator.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/apps/todo.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/apps/notes.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/pages/index.js"></script>

<script>

    $('input').focus(function(){ $(this).next('div').css('display','none')});
    function formValidation(){
        var isVlaid = true;
        if($('input#inp-customer-name').val() == ''){
            $('input#inp-customer-name').next('div').html("*This field is required can't be empty");
            $('input#inp-customer-name').next('div').css('display','block');
            isVlaid = false;
        }/*else{
            if($('input#inp-customer-name').val().length > 16){
                $('input#inp-customer-name').next('div').html('*Input value must be less then equal to 16 character');
                $('input#inp-customer-name').next('div').css('display','block');
                isVlaid = false;
            }

        }*/
        if($('input#inp-customer-email').val() == ''){
            $('input#inp-customer-email').next('div').html("*This field is required can't be empty");
            $('input#inp-customer-email').next('div').css('display','block');
            isVlaid = false;
        }/*else{
            if( $('input#inp-customer-email').val().length > 16){
                $('input#inp-customer-email').next('div').html('*Input value must be less then equal to 16 character');
                $('input#inp-customer-email').next('div').css('display','block');
                isVlaid = false;
            }

        }*/
        if($('#rowId').val() == "") {
            if ($('input#inp-customer-pass').val() == '') {
                $('input#inp-customer-pass').next('div').html("*This field is required can't be empty");
                $('input#inp-customer-pass').next('div').css('display', 'block');
                isVlaid = false;
            } else {
                if ($('input#inp-customer-pass').val().length > 16) {
                    $('input#inp-customer-pass').next('div').html('*Input value must be less then equal to 16 character');
                    $('input#inp-customer-pass').next('div').css('display', 'block');
                    isVlaid = false;
                }

            }
        }
        if($('input#inp-customer-phoneNum').val() == ''){
            $('input#inp-customer-phoneNum').next('div').html("*This field is required can't be empty");
            $('input#inp-customer-phoneNum').next('div').css('display','block');
            isVlaid = false;
        }/*else{
            if($('input#inp-customer-phoneNum').val().length > 16){
                $('input#inp-customer-phoneNum').next('div').html('*Input value must be less then equal to 16 character');
                $('input#inp-customer-phoneNum').next('div').css('display','block');
                isVlaid = false;
            }

        }*/
        if($('input#inp-customer-cnic').val() == ''){
            $('input#inp-customer-cnic').next('div').html("*This field is required can't be empty");
            $('input#inp-customer-cnic').next('div').css('display','block');
            isVlaid = false;
        }/*else{
            if($('input#inp-customer-cnic').val().length > 16){
                $('input#inp-customer-cnic').next('div').html('*Input value must be less then equal to 16 character');
                $('input#inp-customer-cnic').next('div').css('display','block');
                isVlaid = false;
            }

        }*/

        return isVlaid;
    }




    $('#btn-add-detail').on('click',function () {
        if(!formValidation()){
            return;
        }

        if($('#rowId').val() == ""){
            var dataString = generateDataString("new");
        }else{
            var dataString =generateDataString("update");
        }


        //
        // var dataString = '{ "customerName" :"'+$('#inp-customer-name').val()+'",' +
        //     '"customerEmail" :"'+$('#inp-customer-email').val()+'",' +
        //     '"customerPassword" :"'+$('#inp-customer-pass').val()+'",' +
        //     '"customerNic" :"'+$('#inp-customer-cnic').val()+'", ' +
        //     '"customerPhoneNumber" :"'+$('#inp-customer-phoneNum').val()+'", ' +
        //     '"customerAccessType" :"'+$('#inp-customer-status').val()+'" ,' +
        //     '"customerAddressId" : {' +
        //     '"address": "'+$('#inp-customer-address').val()+'",'+
        //     '"city":"karachi"'+
        //     '}'+
        //
        //     '}';



        //console.log(dataString);
        // dataString = JSON.parse(dataString);

        if($('#inp-customer-name').val() != '' && $('#inp-customer-email').val() != '' && $('#inp-customer-pass').val() != '' && $('#inp-customer-cnic').val() != ''
            && $('#inp-customer-phoneNum').val() != ''&& $('#inp-customer-status').val() != '' && $('#inp-customer-address').val() != '')
        {
            $.ajax({
                url:"http://localhost:8080/customer/signup",
                type:"POST",
                data: dataString,
                contentType: 'json',
                dataType: "json",
                contentType: "application/json",
                success:function(response){
                    console.log("Response => ");
                    console.log(response);
                    $("#Message").show();

                }
            });
            window.location = 'customer-listing.html';
        }



    });


    function generateDataString(action){
        if(action == "update"){


            var dataString = '{ "customerId" :"'+$('#rowId').val()+'","customerName" :"'+$('#inp-customer-name').val()+'",' +
                '"customerEmail" :"'+$('#inp-customer-email').val()+'",' +
                '"customerPassword" :"'+$('#inp-customer-pass').val()+'",' +
                '"customerNic" :"'+$('#inp-customer-cnic').val()+'", ' +
                '"customerPhoneNumber" :"'+$('#inp-customer-phoneNum').val()+'", ' +
                '"customerAccessType" :"'+$('#inp-customer-status').val()+'" ,' +
                '"customerAddressId" : {' +
                '"address": "'+$('#inp-customer-address').val()+'",'+
                '"city":"karachi"'+
                '}'+

                '}';
            return dataString;
        }else{
            var dataString = '{ "customerName" :"'+$('#inp-customer-name').val()+'",' +
                '"customerEmail" :"'+$('#inp-customer-email').val()+'",' +
                '"customerPassword" :"'+$('#inp-customer-pass').val()+'",' +
                '"customerNic" :"'+$('#inp-customer-cnic').val()+'", ' +
                '"customerPhoneNumber" :"'+$('#inp-customer-phoneNum').val()+'", ' +
                '"customerAccessType" :"'+$('#inp-customer-status').val()+'" ,' +
                '"customerAddressId" : {' +
                '"address": "'+$('#inp-customer-address').val()+'",'+
                '"city":"karachi"'+
                '}'+

                '}';
            return dataString;
        }
    }

</script>



</body>
</html>