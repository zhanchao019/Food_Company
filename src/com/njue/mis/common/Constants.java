/**
 *定义常量接口
 */

package com.njue.mis.common;

public interface Constants
{
	int PSTM_TYPE=0;
	int CALL_TYPE=1;
	
    //服务类的完整包名
	String GOODS_SERVICES_CLASS="com.njue.mis.services.GoodsServices";
	String CUSTOMER_SERVICES_CLASS="com.njue.mis.services.CustomerServices";
	String PROVIDER_SERVICES_CLASS="com.njue.mis.services.ProviderServices";
	String OPERATOR_SERVICES_CLASS="com.njue.mis.services.OperatorServices";
	String PORTIN_SERVICES_CLASS="com.njue.mis.services.PortInServices";
	String PORTOUT_SERVICES_CLASS="com.njue.mis.services.PortOutServices";
	String SALESIN_SERVICES_CLASS="com.njue.mis.services.SalesInServices";
	String SALESBACK_SERVICES_CLASS="com.njue.mis.services.SalesBackServices";
    String SCHEDULE_SERVICES_CLASS = "com.njue.mis.services.ScheduleServices";
	String PRODUCING_SERVICES_CLASS = "com.njue.mis.services.ProducingServices";
	String LOG_SERVICES_CLASS = "com.njue.mis.services.LogServices";
}
