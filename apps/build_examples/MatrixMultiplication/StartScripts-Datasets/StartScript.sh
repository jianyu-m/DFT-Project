#!/usr/bin/env bash
#create data
matpath1="a1"
matpath2="a2"
matsize=300
iterrounds=1000
cd $MAT_HOME/StartScripts-Datasets
python CreateMatrix.py -m $matpath1 -n $matpath2 -s $matsize  
cd ~/spark-2.1.0-bin-hadoop2.7
./bin/spark-submit --deploy-mode=cluster --master=spark://10.22.1.1:10086 /home/wfan/DFT-Project/apps/build_examples/MatrixMultiplication/target/scala-2.11/matrixmultiplication_2.11-1.0.0.jar /home/wfan/DFT-Project/apps/build_examples/MatrixMultiplication/StartScripts-Datasets/$matpath1 /home/wfan/DFT-Project/apps/build_examples/MatrixMultiplication/StartScripts-Datasets/$matpath2 $iterrounds ./out2 true 


