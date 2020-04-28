package cn.zjut.hotel.service;

import cn.zjut.hotel.domain.HotelMember;
import cn.zjut.hotel.domain.Register;
import cn.zjut.hotel.domain.Table;
import cn.zjut.hotel.repository.HotelMemberMapper;
import cn.zjut.hotel.repository.RegisterMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kuluo
 */
@Service
public class RegisterServiceImpl implements RegisterServiceInterface {
    private RegisterMapper registerMapper;
    private HotelMemberMapper memberMapper;

    @Autowired
    public void setRegisterMapper(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }

    @Autowired
    public void setMemberMapper(HotelMemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Table findRegisters(int pageId, int pageSize, boolean asc, Register register) {
        PageHelper.startPage(pageId, pageSize);

        Example example = new Example(Register.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(register.getRegisterPhone())) {
            criteria.andEqualTo("registerPhone", register.getRegisterPhone());
        }
        if (!StringUtils.isEmpty(register.getRegisterAccount())) {
            criteria.andLike("registerAccount", "%" + register.getRegisterAccount() + "%");
        }

        if (asc) {
            example.orderBy("registerId").asc();
        } else {
            example.orderBy("registerId").desc();
        }

        List<Register> registerList = registerMapper.selectByExample(example);

        long count = ((Page<Register>) registerList).getTotal();

        return new Table(registerList, count);
    }

    @Override
    public boolean modifyOneRegisterById(Register register) {
        Example example = new Example(HotelMember.class);
        example.createCriteria().andGreaterThanOrEqualTo("inScores", register.getMemberScore());
        List<HotelMember> member = memberMapper.selectByExample(example);

        register.setMemberDetail(member.get(0).getMemberDetail());
        register.setMemberDiscount(member.get(0).getMemberDiscount());

        return registerMapper.updateByPrimaryKeySelective(register) > 0;
    }

    @Override
    public boolean addOneRegisterById(Register register) {
        return registerMapper.insertSelective(register) > 0;
    }

    @Override
    public boolean removeOneRegisterById(int registerId) {
        return registerMapper.deleteByPrimaryKey(registerId) > 0;
    }
}
