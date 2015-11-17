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
        	try{
	        	boolean porUf = "UF".equals( context.getConfiguration().get("tipo") );
	        	
	        	String[] colunas = value.toString().split(";");
	        	
	        	String mapKey = (porUf ? colunas[1-1] : colunas[3-1] );
	        	Double accKey = (porUf ? Double.parseDouble(  colunas[11-1].replaceAll(",", "") ) : 1d);
	        	
	        	context.write(new Text(mapKey), new DoubleWritable(accKey) );
        	}catch(Exception e){e.printStackTrace();}
        }        
    }
    

    public static class LogReducer extends Reducer<Text, DoubleWritable, Text, Text> {
    	
    	private static final DecimalFormat df = new DecimalFormat("#.00"); 
    	
    	public void reduce(Text key, Iterable<DoubleWritable> values, Context context)  throws IOException, InterruptedException {
    		double total = 0d;
    		for(DoubleWritable valor:values) {
    			total += valor.get();
    		}
    		
			context.write(new Text(key), new Text( df.format(total)));
    	}
    	
    }
    
	
    public int run(String[] allArgs) throws Exception {
        Job job = Job.getInstance(getConf());
        

	    job.setJarByClass(App.class);
	    
	    job.setMapperClass(LogMapper.class);
	    job.setReducerClass(LogReducer.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(Text.class);
	    job.setMapOutputValueClass(DoubleWritable.class);
	    job.setNumReduceTasks(10);
	    
	
        String[] args = new GenericOptionsParser(getConf(), allArgs).getRemainingArgs();
        
        String tipo = args[0];
        FileInputFormat.setInputPaths(job, new Path(args[1]));
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        
        job.getConfiguration().set("tipo", tipo);

        boolean status = job.waitForCompletion(true);

        if (status) {
            return 0;
        } else {
            return 1;
        }
    }    
	
	public static void main(String[] args) throws Exception  {
	    ToolRunner.run(new App(), args);
	}
	
}