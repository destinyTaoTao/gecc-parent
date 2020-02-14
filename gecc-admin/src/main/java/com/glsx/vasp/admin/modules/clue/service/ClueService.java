package com.glsx.vasp.admin.modules.clue.service;

import cn.hutool.db.Page;
import com.glsx.vasp.admin.modules.clue.dto.ClueSearch;
import com.glsx.vasp.admin.modules.clue.model.ClueDetails;
import com.glsx.vasp.admin.modules.clue.model.ClueListModel;
import com.glsx.vasp.modules.entity.Clue;
import com.glsx.vasp.modules.repository.IClueRepository;
import com.glsx.vasp.utils.ReflectUtils;
import com.glsx.vasp.utils.StringUtils;
import com.glsx.vasp.web.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

@Slf4j
@Service
public class ClueService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IClueRepository repository;

    public Pagination<ClueListModel> search(ClueSearch search, Page page) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append(" select o.id, ");
        sql.append("         o.user_id userId, ");
        sql.append("         o.order_no orderNo, ");
        sql.append("         o.parent_order_no parentOrderNo, ");
        sql.append("         o.status, ");
        sql.append("         o.pay_amount payAmount, ");
        sql.append("         oa.name name, ");
        sql.append("         oa.tel tel, ");
        sql.append("         ol.number logisticsNo, ");
        sql.append("         o.create_time createTime ");
        sql.append(" FROM d_order o ");
        sql.append(" left join d_order_address oa on oa.order_id = o.id ");
        sql.append(" left join d_order_logistics ol on ol.order_id = o.id and ol.del_flag = 0 ");
        sql.append(" left join d_customer c on c.id = o.user_id ");
        sql.append(" where o.del_flag = 0 and o.type= 0 ");

        if (null != search.getStatus()) {
            sql.append(" and o.status=").append(search.getStatus());
        }
        if (StringUtils.isNotBlank(search.getSlSn())) {
            sql.append(" and o.order_no like '%").append(search.getSlSn()).append("%' ");
        }
        if (StringUtils.isNotBlank(search.getMerchantName())) {
            sql.append(" and o.parent_order_no like '%").append(search.getMerchantName()).append("%' ");
        }
        if (StringUtils.isNotBlank(search.getSDate()) && StringUtils.isNotBlank(search.getEDate())) {
            sql.append(" and DATE(o.create_time) between '").append(search.getSDate()).append("' and '").append(search.getEDate()).append("' ");
        }
        sql.append(" order by o.id desc");

        String sqlStr = sql.toString();

        String count = "SELECT count(1) ";
        String substring = sqlStr.substring(0, sql.indexOf("FROM"));

        String countSql = sqlStr.replace(substring, count);

        Query query = entityManager.createNativeQuery(sqlStr);
        Query countQuery = entityManager.createNativeQuery(countSql);

        //设置分页
        if (page != null) {
            query.setFirstResult((page.getPageNumber() - 1) * 10);
            query.setMaxResults(page.getPageSize());
        }

        long total = ((BigInteger) countQuery.getSingleResult()).longValue();

        List list = query.getResultList();

        List<ClueListModel> modelList = ReflectUtils.castEntity(list, ClueListModel.class);
        return new Pagination<>(total, modelList);
    }


    public ClueDetails getDetailsById(Long id) {
        Clue clue = repository.getOne(id);

        return null;
    }

}
