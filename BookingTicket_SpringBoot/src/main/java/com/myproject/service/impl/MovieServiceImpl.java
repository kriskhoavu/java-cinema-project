package com.myproject.service.impl;

import com.myproject.model.common.CONSTANT;
import com.myproject.model.common.ResponseModel;
import com.myproject.model.entity.Movie;
import com.myproject.repository.MovieRepository;
import com.myproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public ResponseModel<Null> insert(Movie model) {
        try {
            movieRepository.save(model);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public ResponseModel<Null> update(Movie model) {
        try {
            if (movieRepository.findById(model.getId()) == null) {
                return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_WARNING, CONSTANT.API_RESPONSE_STATUS_DESC_NOT_FOUND);
            }
            movieRepository.save(model);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public ResponseModel<Null> delete(int id) {
        try {
            movieRepository.deleteById(id);
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_OK, CONSTANT.API_RESPONSE_STATUS_DESC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseModel<Null>(CONSTANT.API_RESPONSE_STATUS_CODE_EXCEPTION, e.getMessage());
        }
    }

    @Override
    public List<Movie> findMoviePlaying(boolean isPlaying) {
        return movieRepository.findMoviePlaying(isPlaying);
    }
}
