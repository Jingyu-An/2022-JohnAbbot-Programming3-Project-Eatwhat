package com.example.eatwhat.service;

import com.example.eatwhat.dao.RecipeRepository;
import com.example.eatwhat.model.Recipe;
import com.example.eatwhat.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class RecipeService {
  
  @Autowired
  private RecipeRepository repo;
  
  public List<Recipe> listAll() {
    return repo.findAll();
  }
  
  public void save(Recipe recipe, @RequestParam("image") MultipartFile multipartFile) throws IOException {
    // For image save
    String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
    recipe.setPhotos(fileName);
    
    Recipe savedRecipe = repo.save(recipe);
    
    String uploadDir = "recipe-photos/" + savedRecipe.getId();
    System.out.println(savedRecipe.getId());
    FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
  }
  
  public Recipe get(long id) {
    return repo.findById(id).get();
  }
  
  public void delete(long id) {
    repo.deleteById(id);
  }
  
}
