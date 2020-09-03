package com.github.gotetu.springangularshowcase.service.recipelist;

import com.github.gotetu.springangularshowcase.view.model.RecipeListView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class RecipeListViewService {
    public List<RecipeListView> findAll() {
        return Collections.emptyList();
    }
}
