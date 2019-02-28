<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ include file="../common/taglib.jsp" %>
<HTML>
<HEAD>
    <META http-equiv=Content-Type CONTENT="text/html; charset=UTF-8"/>
    <TITLE>Newsoft OA</TITLE>
    <LINK HREF="${pageContext.request.contextPath}/style/blue/login.css" type=text/css rel=stylesheet/>
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody>
<FORM METHOD="post" NAME="actForm" ACTION="${pageContext.request.contextPath}/user/login">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/style/blue/images/logo.png"/>
            </DIV>
            <DIV ID="LoginInfo">
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0"
                                                          SRC="${pageContext.request.contextPath}/style/blue/images/login/userId.gif"/>
                        </TD>
                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="text" NAME="loginName"/></TD>
                        <TD ROWSPAN="2" STYLE="padding-left:10px;"><INPUT TYPE="image" SRC="${pageContext.request.contextPath}/style/blue/images/login/userLogin_button.gif"/>
                        </TD>
                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/style/blue/images/login/password.gif"/>
                        </TD>
                        <TD><INPUT SIZE="20" CLASS="TextField" TYPE="password" NAME="userPassword"/></TD>
                    </TR>
                </TABLE>
            </DIV>
            <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2010 ��Ȩ���� newsoft</A></DIV>
        </DIV>
    </DIV>
</FORM>
</BODY>

</HTML>

