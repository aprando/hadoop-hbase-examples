package br.com.am.hadoop;

import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class App extends Configured implements Tool {
		
    public static class LogMapper extends Mapper<Object, Text, Text, DoubleWritable> {
    	
    	/*
    	 * 01 - UF; 
    	 * 02 - Código SIAFI Município; 
    	 * 03 - Nome Município; 
    	 * 04 - Código Função; 
    	 * 05 - Código Subfunção; 
    	 * 06 - Código Programa; 
    	 * 07 - Código Ação; 
    	 * 08 - NIS Favorecido; 
    	 * 09 - Nome Favorecido; 
    	 * 10 - Fonte-Finalidade; 
    	 * 11 - Valor Parcela e Mês Competência.
    	 */
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        }        
    }
    

    public static class LogReducer extends Reducer<Text, DoubleWritable, Text, Text> {
    	
    	private static final DecimalFormat df = new DecimalFormat("#.00"); 
    	
    	public void reduce(Text key, Iterable<DoubleWritable> values, Context context)  throws IOException, InterruptedException {
    	}
    	
    }
    
	
    public int run(String[] allArgs) throws Exception {
    }    
	
	public static void main(String[] args) throws Exception  {
	    ToolRunner.run(new App(), args);
	}
	
}
