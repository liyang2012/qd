package cn.com.myproject.taobao;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.*;
import com.taobao.api.response.*;

public class APITest {

    private static final  String URL = "http://gw.api.taobao.com/router/rest";
    private static final  String APP_KEY = "31026904";
    private static final  String SECRET = "59a758df4ff1204bd4394a0d38513054";

    private TaobaoClient client;

    public APITest() {
        client = new DefaultTaobaoClient(URL, APP_KEY, SECRET);
    }

    /***
     *  1、通过企业名称的全称查询企业的ref_ent_id和ent_id
     *
     *  通过企业名称的全称，通过接口alibaba.alihealth.drugtrace.top.lsyd.query.getentinfo
     *  来查询企业的ref_ent_id和ent_id（入网单位和非入网单位）
     *
     */
    void getentinfo() {
        AlibabaAlihealthDrugtraceTopLsydQueryGetentinfoRequest req = new AlibabaAlihealthDrugtraceTopLsydQueryGetentinfoRequest();
        req.setEntName("开心大药房(测试)");
        AlibabaAlihealthDrugtraceTopLsydQueryGetentinfoResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    /**
     * 2、扫码判定上游出库单是否存在。
     * 各机构收到货物后，首先判定有多少种药品（通用名+剂型+规格+包装规格），然后分别扫每种药品的一个追溯码(大箱码、中包装、最小包装都可以)，
     * 通过扫码,并调接口alibaba.alihealth.drugtrace.top.lsyd.query.upbillcode，扫码判定上游出库单是否存在。
     */
    void upbillcode() {
        AlibabaAlihealthDrugtraceTopLsydQueryUpbillcodeRequest req = new AlibabaAlihealthDrugtraceTopLsydQueryUpbillcodeRequest();
        //追溯码
        req.setCode("81207780265914532355");
        req.setRefEntId("5f742dc2e4b009caa5b865f8");
        AlibabaAlihealthDrugtraceTopLsydQueryUpbillcodeResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    /***
     * 3、通过本机构ref_ent_id查询1个月内上游机构发给本企业的出库单据信息。
     * 通过alibaba.alihealth.drugtrace.top.lsyd.listupout查询一个月内（含当天）上游企业给本机构的出库单据信息。
     * 该出库单包含药品信息和追溯码（不含大中关联关系），以方便机构后面与所获得的实物药品进行核对，进行单据验证。
     */
    void listupout() {
        AlibabaAlihealthDrugtraceTopLsydListupoutRequest req = new AlibabaAlihealthDrugtraceTopLsydListupoutRequest();
        req.setRefEntId("5f742dc2e4b009caa5b865f8");
        req.setBeginDate("2021-09-01");
        req.setEndDate("2021-09-30");
        req.setPageSize(20L);
        req.setPage(1L);

//        //生产批号
//        req.setProduceBatchNo("生产批号0702-01");
//        //药品ID
//        req.setDrugEntBaseInfoId("20b29f58513a48a8a29f04169372d3f5");
//        //单据类型
//        req.setBillType("201");
//        //药品类型
//        req.setPhysicType("3");
//        //状态
//        req.setStatus("1");
//        //单据号
//        req.setBillCode("销售出库-0704");
//        //发货单位
//        req.setFromUserId("a3d6b0f3d6994bacb6055d3e00b2e4bc");
        AlibabaAlihealthDrugtraceTopLsydListupoutResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    /**
     * 4、扫码入库时调用接口验证单据里的药品数量及码各种状态
     *
     * 各机构收到药品后，见码就扫，通过扫码，调用接口alibaba.alihealth.drugtrace.top.lsyd.query.codedetail，
     * 获得药品企业名称+药品通用名+剂型+规格+包装规格+生产日期+有效期+最小包装数量+包装层级+批准文号+码状态+生产批次，
     * 以此来判断是否与所收货物的随行单上的药品和数量是否一致
     *
     */
    void codedetail() {
        AlibabaAlihealthDrugtraceTopLsydQueryCodedetailRequest req = new AlibabaAlihealthDrugtraceTopLsydQueryCodedetailRequest();
        req.setRefEntId("5f742dc2e4b009caa5b865f8");
        req.setCodes("BC001_112360008");
        AlibabaAlihealthDrugtraceTopLsydQueryCodedetailResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    /**
     * 5、按照追溯平台的采购入库的XML文件格式，调用alibaba.alihealth.drugtrace.top.lsyd.uploadinoutbill
     *   上传除零售出库以外的其他入出库单据。
     *
     */
    void uploadinoutbill() {
        AlibabaAlihealthDrugtraceTopLsydUploadinoutbillRequest req = new AlibabaAlihealthDrugtraceTopLsydUploadinoutbillRequest();
        req.setBillCode("BC001_202110091141003");
        req.setBillTime(StringUtils.parseDateTime("2021-10-09 11:41:51"));
        req.setBillType(102L);
        req.setPhysicType(3L);
        req.setRefUserId("5f742dc2e4b009caa5b865f8");
        //req.setAgentRefUserId("320000000000127971");
        req.setFromUserId("5f742dc2e4b009caa5b865f8");
        req.setToUserId("5f742dc2e4b009caa5b865f8");
        //req.setDestUserId("5f742dc2e4b009caa5b865f8");
        req.setOperIcCode("25541677");
        req.setOperIcName("张三");
        req.setClientType("2");
//        req.setReturnReasonCode("1");
//        req.setReturnReasonDes("退货原因描述");
//        req.setCancelReasonCode("1");
//        req.setCancelReasonDes("注销原因描述");
//        req.setExecuterName("执行人");
//        req.setExecuterCode("11034564321");
//        req.setSuperviserName("监督人");
//        req.setSuperviserCode("11276789342");
//        req.setWarehouseId("W001");
//        req.setDrugId("D001");
        req.setTraceCodes("81012350000000157474");
//        req.setFromAddress("发货地址XXX");
//        req.setToAddress("收货地址XXX");
//        req.setFromBillCode("123456");
//        req.setOrderCode("123456");
//        req.setFromPerson("张某");
//        req.setToPerson("李某");
//        req.setDisRefEntId("5069452c34b94a778abaa26c2b40b305");
//        req.setDisEntId("5069452c34b94a778abaa26c2b40b305");
//        req.setQuReceivable(10L);
//        req.setXtIsCheck("0");
//        req.setXtCheckCode("未验证通过原因");
//        req.setXtCheckCodeDesc("未通过原因描述");
//        req.setDrugListJson("[{\"codeCount\":100,\"commDrugId\":\"testCommDrugId0\",\"exprieDate\":1571131734945,\"physicInfo\":\"test0\",\"pkgSpec\":\"test0\",\"prepnCount\":10,\"produceBatchNo\":\"test0\",\"produceDate\":1571131734945},{\"codeCount\":100,\"commDrugId\":\"testCommDrugId1\",\"exprieDate\":1571131734945,\"physicInfo\":\"test1\",\"pkgSpec\":\"test1\",\"prepnCount\":10,\"produceBatchNo\":\"test1\",\"produceDate\":1571131734945}]");
//        req.setAssRefEntId("5069452c34b94a778abaa26c2b40b305");
//        req.setAssEntId("5069452c34b94a778abaa26c2b40b305");
        AlibabaAlihealthDrugtraceTopLsydUploadinoutbillResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    /**
     * 6、上传入库单据后，可以通过入库单据号，调用接口，alibaba.alihealth.drugtrace.top.lsyd.query.billstatus查询单据的处理状态
     */
    void billstatus() {
        AlibabaAlihealthDrugtraceTopLsydQueryBillstatusRequest req = new AlibabaAlihealthDrugtraceTopLsydQueryBillstatusRequest();
        req.setRefEntId("5f742dc2e4b009caa5b865f8");
        req.setBeginDate("2021-09-01");
        req.setEndDate("2021-09-30");
        req.setBillType("A");
//        req.setBillCode("SYS_IN_201811061737543754_0002");
//        req.setDrugType("1");
//        req.setDealStatus("1");
//        req.setFromUserId("320000000000127971");
//        req.setToUserId("320000000000127971");
//        req.setAgentRefUserId("320000000000127971");
        req.setPageSize(20L);
        req.setPage(1L);
        AlibabaAlihealthDrugtraceTopLsydQueryBillstatusResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    /***
     * 7、通过alibaba.alihealth.drugtrace.top.lsyd.uploadretail接口上传零售出库单据
     */
    void uploadretail() {

        AlibabaAlihealthDrugtraceTopLsydUploadretailRequest req = new AlibabaAlihealthDrugtraceTopLsydUploadretailRequest();
        req.setBillCode("DR000_202110091141003");
        req.setBillTime(StringUtils.parseDateTime("2021-10-09 11:42:21"));
        req.setBillType(321L);
        req.setPhysicType(3L);
        req.setRefUserId("5f742dc2e4b009caa5b865f8");
//        req.setFromUserId("320000002332");
//        req.setOperIcCode("2100000345");
//        req.setOperIcName("张三");
        req.setTraceCodes("81207780265914532355");
//        req.setCustomerIdType("5");
//        req.setCustomerId("60123456789");
//        req.setUserTel("13012341234");
//        req.setNetworkBillFlag("0");
//        req.setMedicDoctor("张三");
//        req.setMedicDispenser("李四");
//        req.setUserName("王五");
//        req.setUserAgent("毛六");
        AlibabaAlihealthDrugtraceTopLsydUploadretailResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    /**
     * 8-1、查询关联关系
     * 通过过入库单据号查询关联关系，调用接口alibaba.alihealth.drugtrace.top.lsyd.query.upbilldetail
     */
    void upbilldetail() {
        AlibabaAlihealthDrugtraceTopLsydQueryUpbilldetailRequest req = new AlibabaAlihealthDrugtraceTopLsydQueryUpbilldetailRequest();
        req.setBillCode("BC001_202110091141001");
        req.setRefEntId("5f742dc2e4b009caa5b865f8");
        AlibabaAlihealthDrugtraceTopLsydQueryUpbilldetailResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

    /**
     * 8-2、查询关联关系
     * 通过码查询关联关系接口，获得关联关系，调用接口alibaba.alihealth.drugtrace.top.lsyd.query.relation
     */
    void relation() {
        AlibabaAlihealthDrugtraceTopLsydQueryRelationRequest req = new AlibabaAlihealthDrugtraceTopLsydQueryRelationRequest();
        req.setCode("81207780265914532355");
        req.setRefEntId("5f742dc2e4b009caa5b865f8");
        req.setDesRefEntId("5f742dc2e4b009caa5b865f8");
        AlibabaAlihealthDrugtraceTopLsydQueryRelationResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        APITest test = new APITest();
        System.out.println("1、通过企业名称的全称查询企业的ref_ent_id和ent_id");
        test.getentinfo();
        System.out.println("\n2、扫码判定上游出库单是否存在");
        test.upbillcode();
        System.out.println("\n3、通过本机构ref_ent_id查询1个月内上游机构发给本企业的出库单据信息");
        test.listupout();
        System.out.println("\n4、扫码入库时调用接口验证单据里的药品数量及码各种状态");
        test.codedetail();
        System.out.println("\n5、按照追溯平台的采购入库的XML文件格式，调用alibaba.alihealth.drugtrace.top.lsyd.uploadinoutbill" +
                "上传除零售出库以外的其他入出库单据。");
        test.uploadinoutbill();
        System.out.println("\n6、上传入库单据后，可以通过入库单据号，调用接口，alibaba.alihealth.drugtrace.top.lsyd.query.billstatus查询单据的处理状态");
        test.billstatus();
        System.out.println("\n7、通过alibaba.alihealth.drugtrace.top.lsyd.uploadretail接口上传零售出库单据");
        test.uploadretail();
        System.out.println("\n8-1、查询关联关系  通过过入库单据号查询关联关系，调用接口alibaba.alihealth.drugtrace.top.lsyd.query.upbilldetail");
        test.upbilldetail();
        System.out.println("\n8-2、查询关联关系 通过码查询关联关系接口，获得关联关系，调用接口alibaba.alihealth.drugtrace.top.lsyd.query.relation");
        test.relation();
    }
}
