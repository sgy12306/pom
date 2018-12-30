package com.itheima;

import org.apache.lucene.analysis.Analyzer;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.security.PublicKey;

public class Testlucesss {

    @Test
    public void test() throws IOException {
        //1.读取本地磁盘的所有文本文件
        IndexWriter writer = null;
        /**
         * 1或得要添加索引库的文件
         * 2遍历每个文件，将文件添加到document对象中
         * 3配置索引库写入对象，告知索引库位置，和分词器
         */
        File Dirfile = new File("D:\\searchsource");
        File[] files = Dirfile.listFiles();
        Directory directory = FSDirectory.open(new File("D:\\luceneIndex"));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
        writer = new IndexWriter(directory, config);
        for (File file : files) {
            Document document = new Document();
            document.add(new TextField("fileName",file.getName(), Field.Store.YES));
            document.add(new TextField("fileContent",FileUtils.readFileToString(file), Field.Store.YES));
            document.add(new LongField("fileSize",file.length(), Field.Store.YES));
            document.add(new StringField("filePath",file.getPath(), Field.Store.YES));            //先删除再添加
            //writer.updateDocument(new Term("filename","spring"),document);
            writer.addDocument(document);
        }
        writer.close();

    }
    //查询所有
    @Test
    public void query() {
        try {
            //创建索引库读取对象 目的读取之前创建的索引库目录
            IndexReader reader = DirectoryReader.open(FSDirectory.open(new File("D:\\luceneIndex")));
            IndexSearcher searcher = new IndexSearcher(reader);
            Query query = new MatchAllDocsQuery();
            searcher.search(query, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
