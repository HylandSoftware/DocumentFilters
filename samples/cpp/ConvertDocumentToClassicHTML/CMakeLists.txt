cmake_minimum_required(VERSION 3.15)

add_executable (ConvertDocumentToClassicHTML "ConvertDocumentToClassicHTML.cpp")
target_link_libraries (ConvertDocumentToClassicHTML PUBLIC DocumentFiltersSamples)