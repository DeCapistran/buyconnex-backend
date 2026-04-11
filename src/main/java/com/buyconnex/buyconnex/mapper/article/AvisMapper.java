package com.buyconnex.buyconnex.mapper.article;

import com.buyconnex.buyconnex.entity.article.Avis;
import com.buyconnex.buyconnex.entity.article.Articles;
import com.buyconnex.buyconnex.entity.user.Users;
import com.buyconnex.buyconnex.mapper.user.UserMapper;
import com.buyconnex.buyconnex.vo.article.AvisVo;

public class AvisMapper {

    public static AvisVo toVO(Avis avis) {
        if (avis == null) return null;

        AvisVo avisVo = new AvisVo();
        avisVo.setId(avis.getAvis_id());
        avisVo.setDateAvis(avis.getDateAvis());
        avisVo.setEtoile(avis.getEtoile());
        avisVo.setCommentaire(avis.getCommentaire());

        // IMPORTANT : versions simples pour éviter la récursivité
        avisVo.setArticles(ArticleMapper.toVO_Simple(avis.getArticles()));
        avisVo.setUsers(UserMapper.toVO_Simple(avis.getUsers()));

        return avisVo;
    }

    public static AvisVo toVO_Simple(Avis avis) {
        if (avis == null) return null;

        AvisVo avisVo = new AvisVo();
        avisVo.setId(avis.getAvis_id());
        avisVo.setDateAvis(avis.getDateAvis());
        avisVo.setEtoile(avis.getEtoile());
        avisVo.setCommentaire(avis.getCommentaire());

        // On ne remonte pas le graphe
        avisVo.setArticles(null);
        avisVo.setUsers(null);

        return avisVo;
    }

    public static Avis toEntity(AvisVo avisVo) {
        if (avisVo == null) return null;

        Avis avis = new Avis();
        avis.setAvis_id(avisVo.getId());
        avis.setDateAvis(avisVo.getDateAvis());
        avis.setEtoile(avisVo.getEtoile());
        avis.setCommentaire(avisVo.getCommentaire());

        // IMPORTANT : références par id uniquement
        avis.setArticles(toArticleRef(avisVo));
        avis.setUsers(toUserRef(avisVo));

        return avis;
    }

    public static void updateEntityFromVO(AvisVo avisVo, Avis avis) {
        if (avisVo == null || avis == null) return;

        avis.setAvis_id(avisVo.getId());
        avis.setDateAvis(avisVo.getDateAvis());
        avis.setEtoile(avisVo.getEtoile());
        avis.setCommentaire(avisVo.getCommentaire());

        avis.setArticles(toArticleRef(avisVo));
        avis.setUsers(toUserRef(avisVo));
    }

    private static Articles toArticleRef(AvisVo avisVo) {
        if (avisVo.getArticles() == null || avisVo.getArticles().getId() == null) {
            return null;
        }

        Articles article = new Articles();
        article.setArticle_id(avisVo.getArticles().getId());
        return article;
    }

    private static Users toUserRef(AvisVo avisVo) {
        if (avisVo.getUsers() == null || avisVo.getUsers().getId() == null) {
            return null;
        }

        Users user = new Users();
        user.setUserId(avisVo.getUsers().getId());
        return user;
    }
}