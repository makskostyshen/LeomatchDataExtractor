package org.acme.demo.file.parse;

import org.springframework.stereotype.Service;

@Service
public class FileParseService {

  public String parse(String fileName) {
    return "file is parsed";
  }
}
