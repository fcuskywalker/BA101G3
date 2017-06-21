<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- �����m�߱ĥ� EL ���g�k���� --%>

<jsp:useBean id="listAFs_ByAuth_No" scope="request" type="java.util.Set"/>
<jsp:useBean id="authority_FeatureSvc" scope="page" class="com.admin.model.Authority_FeatureService"/>
<html>
<head>
    <title>���u�v�� - listAFs_ByAuth_No.jsp</title>
</head>
<body bgcolor='white'>


<h3>���u�v�� - listAFs_ByAuth_No.jsp</h3>
<h3><a href="<%=request.getContextPath()%>/select_page.jsp">
    <img src="images/babeq3.png" width="100" height="32" border="0">�^����
</a>
</h3>


<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
    <ul>
        <h5 color='red'>�Эץ��H�U���~:</h5>
        <c:forEach var="message" items="${errorMsgs}">
            <li>${message}</li>
        </c:forEach>
    </ul>
    </font>
</c:if>

<table border='1' bordercolor='#CCCCFF' width='800'>
    <tr>
        <th>�v���s��</th>
        <th>�v���W��</th>

    </tr>

    <c:forEach var="authority_FeatureVO" items="${listAFs_ByAuth_No}">
        <tr align='center' valign='middle' ${(authority_FeatureVO.auth_no==param.auth_no) ? 'bgcolor=#CCCCFF':''}>
            <!--�N�ק諸���@���[�J����Ӥw-->
            <td>${authority_FeatureVO.auth_no}</td>
            <td>${authority_FeatureVO.auth_name}</td>
            <td color=orange>
                <c:forEach var="authority_FeatureVO" items="${admin_AuthorityService.all}">
                    <c:if test="${admin_AuthorityVO.auth_no==authority_FeatureVO.auth_no}">
                        �i${admin_AuthorityVO.adm_name} - ${authority_FeatureVO.auth_name}�j
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do">
                    <input type="submit" value="�ק�">
                    <input type="hidden" name="empno" value="${authority_FeatureVO.empno}">
                    <input type="hidden" name="requestURL" value="<%=request.getServletPath()%>">
                    <!--�e�X�����������|��Controller-->
                    <input type="hidden" name="action" value="getOne_For_Update"></FORM>
            </td>

        </tr>
    </c:forEach>
</table>

<br>�����������|:<br><b>

    <p color=blue>
        request.getServletPath():<%= request.getServletPath()%>
    </p>
    <p color=blue>
        request.getRequestURI():<%= request.getRequestURI()%>
    </p>

</body>
</html>
