package com.buyconnex.buyconnex.mapper.client;

import java.util.Set;
import java.util.stream.Collectors;

import com.buyconnex.buyconnex.entity.client.Paniers;
import com.buyconnex.buyconnex.entity.client.PaniersDetails;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.client.PaniersVo;

public class PanierMapper {

	public static PaniersVo toVO(Paniers paniers) {
        if (paniers == null) return null;

        PaniersVo vo = new PaniersVo();
        vo.setId(paniers.getPaniers_id());
        vo.setDatePanier(paniers.getDatePanier());
        vo.setUsers(UserMapper.toVO(paniers.getUsers()));

        vo.setPaniersDetails(
                paniers.getPaniersDetails() == null ? null :
                        paniers.getPaniersDetails().stream()
                                .map(PanierDetailMapper::toVo)
                                .collect(Collectors.toSet())
        );

        return vo;
    }

    /** Simple : sans détails */
    public static PaniersVo toVO_Simple(Paniers paniers) {
        if (paniers == null) return null;

        PaniersVo vo = new PaniersVo();
        vo.setId(paniers.getPaniers_id());
        vo.setDatePanier(paniers.getDatePanier());
        vo.setUsers(UserMapper.toVO(paniers.getUsers()));
        vo.setPaniersDetails(null);

        return vo;
    }

    /** Référence (id only) */
    public static Paniers toEntityRef(PaniersVo vo) {
        if (vo == null || vo.getId() == null) return null;
        Paniers ref = new Paniers();
        ref.setPaniers_id(vo.getId());
        return ref;
    }

    public static Paniers toEntity(PaniersVo vo) {
        if (vo == null) return null;

        Paniers entity = new Paniers();
        entity.setPaniers_id(vo.getId());
        entity.setDatePanier(vo.getDatePanier());

        // Users : en référence (id only) pour éviter reconstruction
        if (vo.getUsers() != null && vo.getUsers().getId() != null) {
            Users u = new Users();
            u.setUser_id(vo.getUsers().getId());
            entity.setUsers(u);
        } else {
            entity.setUsers(null);
        }

        if (vo.getPaniersDetails() != null) {
            Set<PaniersDetails> details = vo.getPaniersDetails().stream()
                    .map(PanierDetailMapper::toEntity)
                    .collect(Collectors.toSet());

            // IMPORTANT : rattacher le parent
            details.forEach(d -> d.setPaniers(entity));
            entity.setPaniersDetails(details);
        } else {
            entity.setPaniersDetails(null);
        }

        return entity;
    }

    public static void updateEntityFromVO(PaniersVo vo, Paniers entity) {
        if (vo == null || entity == null) return;

        entity.setPaniers_id(vo.getId());
        entity.setDatePanier(vo.getDatePanier());

        if (vo.getUsers() != null && vo.getUsers().getId() != null) {
            Users u = new Users();
            u.setUser_id(vo.getUsers().getId());
            entity.setUsers(u);
        } else {
            entity.setUsers(null);
        }

        if (vo.getPaniersDetails() != null) {
            Set<PaniersDetails> details = vo.getPaniersDetails().stream()
                    .map(PanierDetailMapper::toEntity)
                    .collect(Collectors.toSet());
            details.forEach(d -> d.setPaniers(entity));
            entity.setPaniersDetails(details);
        } else {
            entity.setPaniersDetails(null);
        }
    }
}
