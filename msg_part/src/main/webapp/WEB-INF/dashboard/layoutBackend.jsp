<%--<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%--<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>--%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><html lang="en" class="no-js"><![endif]-->
<!-- BEGIN HEAD -->
<head>
    <!-- START META SECTION -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="xxx">
    <meta name="keywords" content="xxx">
    <meta name="author" content="xxx">
    <!--/ END META SECTION -->

    <!-- START FAVICONS -->

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo">
<tiles:insertAttribute name="header"/>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar-wrapper">
        <!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
        <!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
        <div class="page-sidebar navbar-collapse collapse">
            <!-- BEGIN SIDEBAR MENU -->
            <ul class="page-sidebar-menu page-sidebar-menu-light" data-auto-scroll="true" data-slide-speed="200">
                <!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
                <li class="<tiles:insertAttribute name="menuDashboard" ignore="true"/>">
                    <a href="<c:url value="/"/>">
                        <i class="icon-home"></i>
                        <span class="title">Dashboard</span>
                        <span class="selected"></span>
                    </a>
                </li>


                <!-- END : MENU USAHA PT. BAG-->
                <c:if test="${authUser.getGroups().get(0).getId()==2}">
                    <li class="<tiles:insertAttribute name="menuKontrak" ignore="true"/>">
                        <a href="javascript:void(0);">
                            <i class="icon-pencil"></i>
                            <span class="title">Kontrak</span>
                            <span class="selected"></span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="<tiles:insertAttribute name="menuKontrakKSO" ignore="true"/>">
                                <%--<a href="<c:url value="/kontrak/mitra-kso"/>">Mitra KSO</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuKontrakFN" ignore="true"/>">
                                <%--<a href="<c:url value="/kontrak/mitra-fn"/>">Mitra KSO Spot</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuKontrakPelanggan" ignore="true"/>">
                                <%--<a href="<c:url value="/kontrak/pelanggan"/>">Pelanggan</a>--%>
                            </li>
                            <%--<li class="<tiles:insertAttribute name="menuKontrakAmandemen" ignore="true"/>">
                                <a href="<c:url value="/kontrak/amandemen"/>">Amandemen</a>
                            </li>--%>
                            <li class="<tiles:insertAttribute name="menuKontrakTimeCharter" ignore="true"/>">
                                <%--<a href="<c:url value="/kontrak/timecharter"/>">Time Charter</a>--%>
                            </li>
                        </ul>
                    </li>
                    <li class="<tiles:insertAttribute name="menuMitraApproval" ignore="true"/>">
                    <%--<a href="<c:url value="/master-mitra/mitra-approval"/>">--%>
                        <i class="icon-check"></i>
                        <span class="title">Approval Register Mitra</span>
                        <span class="selected"></span>
                    </a>
                    </li>

                    <li class="<tiles:insertAttribute name="menuKapal" ignore="true"/>">
                        <a href="<c:url value=""/>">
                            <i class="icon-anchor"></i>
                            <span class="title">Management Kapal</span>
                            <span class="selected"></span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="<tiles:insertAttribute name="menuApprovalKapal" ignore="true"/>">
                                <%--<a href="<c:url value="/kapal/bag-approval-kapal"/>"> Approval Kapal</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuDaftarKapal" ignore="true"/>">
                                <%--<a href="<c:url value="/kapal"/>"> Daftar Kapal</a>--%>
                            </li>
                        </ul>
                    </li>
                    <!-- Menu Notifikasi-->
                    <li class="<tiles:insertAttribute name="menuNotif" ignore="true"/>">
                        <%--<a href="<c:url value="/notification"/>">--%>
                            <i class="icon-bell"></i>
                            <span class="title">Notifikasi</span>
                            <span class="selected"></span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="<tiles:insertAttribute name="menuListNotifikasi" ignore="true"/>">
                                <%--<a href="<c:url value="/notification"/>"> Rekap Notifikasi </a>--%>
                            </li>
                        </ul>
                    </li>

                    <li class="<tiles:insertAttribute name="menuJadwal" ignore="true"/>">
                        <%--<a href="<c:url value="/jadwal"/>">--%>
                            <i class="icon-clock"></i>
                            <span class="title">Shipment</span>
                            <span class="selected"></span>
                            <span class="arrow"></span>
                        </a>
                        <ul class="sub-menu">
                            <li class="<tiles:insertAttribute name="menuRakor" ignore="true"/>">
                                <%--<a href="<c:url value="/jadwal/rakor"/>"> Rakor</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuLaycan" ignore="true"/>">
                                <%--<a href="<c:url value="/jadwal/laycan"/>"> Laycan</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuWO" ignore="true"/>">
                                <%--<a href="<c:url value="/jadwal/work-order"/>">Work Order</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuLI" ignore="true"/>">
                                <%--<a href="<c:url value="/jadwal/loading-info"/>">Loading Info</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuUnloading" ignore="true"/>">
                                <%--<a href="<c:url value="/unloading"/>">Unloading</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuMonitoringShipment" ignore="true"/>">
                                <%--<a href="<c:url value="/monitoring-shipment"/>">Monitoring Shipment</a>--%>
                            </li>
                            <li class="<tiles:insertAttribute name="menuKoreksiShipment" ignore="true"/>">
                                <%--<a href="<c:url value="/koreksi-shipment"/>">Koreksi Shipment</a>--%>
                            </li>
                        </ul>
                    </li>
                    <%--<li>
                        <a href="javascript:;">
                            <i class="icon-map"></i>
                            <span class="title"> Tracking Kapal</span>
                        </a>
                    </li>--%>




            </ul>
            <!-- END SIDEBAR MENU -->
        </div>
    </div>
    <!-- END SIDEBAR -->
    <tiles:insertAttribute name="body"/>
</div>
<!-- END CONTAINER -->

<tiles:insertAttribute name="footer"/>

<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>

                    <!--<script src="<c:url value='/assets/js/plugins/respond.min.js'/>"></script>-->
<!--<script src="<c:url value='/assets/js/plugins/excanvas.min.js'/>"></script>-->

                    <![endif]-->
<%--<script src="<c:url value="/assets/js/main.js"/>"></script>--%>
<!-- END CORE PLUGINS -->


                    <!-- BEGIN PAGE LEVEL SCRIPTS -->
<tiles:importAttribute name="scriptFiles" ignore="true"/>
<c:forEach var="script" items="${scriptFiles}">
<script src="<c:url value="/"/><c:url value="${script}"/>"></script>
</c:forEach>

<tiles:importAttribute name="pluginJS" ignore="true"/>
<c:forEach var="scriptJS" items="${pluginJS}">
    <script src="<c:url value="${scriptJS}"/>"></script>
</c:forEach>


<script src="<c:url value="/"/><tiles:getAsString name='script'/>"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<!-- END JAVASCRIPTS -->

</body>
<!-- END BODY -->
</html>