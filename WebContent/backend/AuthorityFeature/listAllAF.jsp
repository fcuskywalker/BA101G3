<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="com.admin.model.*" %>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%-- <%
   /*  Authority_FeatureService authority_FeatureSvc = new Authority_FeatureService();
     List<Authority_FeatureVO> list = authority_FeatureSvc.getAll();
     pageContext.setAttribute("list",list); */
%> --%>

<jsp:useBean id="authority_FeatureSvc" scope="page"
             class="com.admin.model.Authority_FeatureService"/>

<html>
<head>
    <title>�Ҧ����� - listAllAF.jsp</title>
    <!-- Bootstrap core CSS -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <!--external css  ICON-->
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
    <link href="../assets/font-awesome/css/font-awesome.css"
          rel="stylesheet"/>
    <link
            href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
            rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="../assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css"
          href="../assets/js/gritter/css/jquery.gritter.css"/>
    <link rel="stylesheet" type="text/css"
          href="../assets/lineicons/style.css">
    <link href="../assets/css/style-responsive.css" rel="stylesheet">
    <link href="../assets/css/table-responsive.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../assets/css/style.css" rel="stylesheet">
    <link href="../assets/css/style-responsive.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        body {
            font-family: Microsoft JhengHei;
        }
    </style>
</head>
<body>

<!-- **********************************************************************************************************************************************************
MAIN SIDEBAR MENU
*********************************************************************************************************************************************************** -->
<!--sidebar start ������-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            <p class="centered">
                <a href="index.html">
                    <img src="images/babeq3.png" width="190">
                </a>
            </p>
            <h5 class="centered" style="font-size: 24px; font-family: 'Microsoft JhengHei';">
                <a href="javascript:;">
                    <span style="color: #636363">
                        <i class="fa fa-sign-out" aria-hidden="true"></i>
                        ����</span>
                </a>
            </h5>
            

            <li class="sub-menu">
                <a href="javascript:;">
                    <i class="fa fa-desktop"></i>
                    <span>�|����ƺ޲z</span>
                </a>
                <ul class="sub">
                    <li><a href="member/member_expert.html">�M�a�f��</a></li>
                    <li><a href="member/member_grade.html">��`�����f��</a></li>
                    <li><a href="member/buyer_report.html">�R�a���|</a></li>
                    <li><a href="member/seller_reprot.html">��a���|</a></li>
                    <li><a href="member/product_report.html">�ӫ~���|</a></li>
                    <li><a href="member/product_message_report.html">�ӫ~�d�����|</a></li>
                    <li><a href="member/answer_report.html">�^�а��D���|</a></li>
                    <li><a href="member/article_message_report.html">�d�����|</a></li>
                    <li><a href="basic_report.html">��ѫǥΤ����|</a></li>
                    <li><a href="panels.html">�|����ƺ޲z-�峹</a></li>
                    <li><a href="panels.html">�|����ƺ޲z-�Ӯa</a></li>
                    <li><a href="panels.html">�|����ƺ޲z-��ѫ�</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;">
                    <i class="fa fa-car"></i>
                    <span>���˸�ƺ޲z</span>
                </a>
                <ul class="sub">
                    <li><a href="basic_map.html">�a�Ͼ��c</a></li>

                    <li><a href="todo_list.html">�ƭ��~</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="javascript:;">
                    <i class="fa fa-book"></i>
                    <span>�����޲z</span>
                </a>
                <ul class="sub">
                    <li><a href="blank.html">�ʪ��Ϥ���</a></li>
                    <li><a href="login.html">�峹����</a></li>
                    <li><a href="lock_screen.html">�ӫ~����</a></li>
                    <li><a href="lock_screen.html">���D����</a></li>
                    <li><a href="lock_screen.html">�M�a����</a></li>
                </ul>
            </li>
            <li class="sub-menu">
                <a href="basic_news.html">
                    <i class="fa fa-bell"></i>
                    <span>�̷s�����޲z</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;">
                    <i class="fa fa-credit-card"></i>
                    <span>���u�b��޲z</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;">
                    <i class=" fa fa-legal"></i>
                    <span>�v���޲z</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;">
                    <i class=" fa fa-database"></i>
                    <span>�t�ΰѼƺ޲z</span>
                </a>
            </li>
            <li class="sub-menu">
                <a href="javascript:;">
                    <i class="fa fa-bar-chart-o"></i>
                    <span>��x���R�޲z</span>
                </a>
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<!-- **********************************************************************************************************************************************************
MAIN CONTENT  �o��}�l�� BBQ
*********************************************************************************************************************************************************** -->
<!--main content start-->
<section id="main-content">
    <section class="wrapper">
        <h3>
            <i class="fa fa-angle-right"></i> <a
                href="<%=request.getContextPath()%>/select_page.jsp"> <img
                src="images/babeq3.png" width="378" height="141" border="0">
        </a>
        </h3>
        <%-- ���~��C --%>
        <c:if test="${not empty errorMsgs}">
            <ul>
                �Эץ��H�U���~:
                <c:forEach var="message" items="${errorMsgs}">
                    <li>${message}</li>
                </c:forEach>
            </ul>
        </c:if>
        <div class="row">
            <div class="col-md-12">
                <div class="content-panel">
                    <table class="table table-striped table-advance table-hover">
                        <h4>
                            <i class="fa fa-angle-right"></i>���u�v���޲z - ListAllAF.jsp
                        </h4>
                        <hr>
                        <thead>
                        <tr>
                            <th><i class="fa fa-bullhorn"></i>�v���s��</th>
                            <th><i class="fa fa-bullhorn"></i>�v���W��</th>
                            <th class="hidden-phone"><i class="fa fa-question-circle"></i>�ק�</th>
                            <th class="fa fa-bookmark" style="color: red">�R��</th>
                            <th><i class=" fa fa-edit"></i> �d��</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="authority_FeatureVO" items="${authority_FeatureSvc.all}">
                            <tr>
                                <td>${authority_FeatureVO.auth_no}</td>
                                <td>${authority_FeatureVO.auth_name}</td>
                                <td>
                                    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/AuthorityFeatureServlet.do">
                                    <button class="btn btn-large"><i class="icon-pencil icon-spin"></i> �ק�</button>
                                    <input type="submit" value="�ק�" disabled="true">
                                    <input type="hidden" name="auth_no" value="${authority_FeatureVO.auth_no}">
                                    <%--<input type="hidden" name="action" value="getOne_For_Update_Dept">--%>
                                    </FORM>
                                </td>
                                <td>
                                    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/AuthorityFeatureServlet.do">
                                    <button class="btn btn-large"><i class="icon-ban-circle icon-spin"></i> �R��</button>
                                        <input type="submit" value="�R��"> 
                                        <input type="hidden" name="auth_no" value="${authority_FeatureVO.auth_no}">
                                        <input type="hidden" name="action" value="deleteAF">
                                    </FORM>
                                </td>
                                <td>
                                    <FORM METHOD="post"
                                          ACTION="<%=request.getContextPath()%>/AuthorityFeatureServlet.do">
                                        <button class="btn btn-large">
                                            <i class="icon-refresh icon-spin"></i> �d��
                                        </button>
                                        <input type="submit" value="�e�X�d��"> <input
                                            type="hidden" name="auth_no"
                                            value="${authority_FeatureVO.auth_no}"> <input
                                            type="hidden" name="action" value="listAFs_ByAuth_No_B">
                                    </FORM>
                                </td>
                            </tr>
                           
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /content-panel -->
            </div>
            <!-- /col-md-12 -->
        </div>
        <!-- /row -->
        <!-- /row -->
        <div class="row mt">
            <div class="col-md-12">
                <div class="content-panel">
                    <table class="table table-striped table-advance table-hover">
                        <h4>
                            <i class="fa fa-angle-right"></i> �ݼf�����|
                        </h4>
                        <hr>
                        <thead>
                        <tr>
                            <th><i class="fa fa-bullhorn"></i> �Q���|���O</th>
                            <th class="hidden-phone"><i class="fa fa-question-circle"></i>
                                �Q���|�H
                            </th>
                            <th><i class="fa fa-bookmark"></i>���|���e</th>
                            <th><i class=" fa fa-edit"></i> Status</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><a href="basic_table.html#">Company Ltd</a></td>
                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                            <td>12000.00$</td>
                            <td><a href="#" class="btn btn-default"><span
                                    class="glyphicon glyphicon-share-alt"></span> �i�}</a></td>

                        </tr>
                        <tr>
                            <td><a href="basic_table.html#"> Dashgum co </a></td>
                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                            <td>17900.00$</td>
                            <td><a href="#" class="btn btn-default"><span
                                    class="glyphicon glyphicon-share-alt"></span> �i�}</a></td>

                        </tr>
                        <tr>
                            <td><a href="basic_table.html#"> Another Co </a></td>
                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                            <td>14400.00$</td>
                            <td><a href="#" class="btn btn-default"><span
                                    class="glyphicon glyphicon-share-alt"></span> �i�}</a></td>

                        </tr>
                        <tr>
                            <td><a href="basic_table.html#"> Dashgum ext </a></td>
                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                            <td>22000.50$</td>
                            <td><a href="#" class="btn btn-default"><span
                                    class="glyphicon glyphicon-share-alt"></span> �i�}</a></td>

                        </tr>
                        <tr>
                            <td><a href="basic_table.html#">Total Ltd</a></td>
                            <td class="hidden-phone">Lorem Ipsum dolor</td>
                            <td>12120.00$</td>
                            <td><a href="#" class="btn btn-default"><span
                                    class="glyphicon glyphicon-share-alt"></span> �i�}</a></td>

                        </tr>
                        </tbody>
                    </table>
                </div>
                <!-- /content-panel -->
            </div>
            <!-- /col-md-12 -->
        </div>
        <!-- /row -->
    </section>
    <! --/responsive wrapper -->
</section>
<!--main content end-->
<%
    if (request.getAttribute("listAFs_ByAuth_No") != null) {
%>
<jsp:include page="listAFs_ByAuth_No.jsp"/>
<%
    }
%>

</body>
</html>
