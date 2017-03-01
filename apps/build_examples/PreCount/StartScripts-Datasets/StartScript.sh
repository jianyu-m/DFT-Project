#!/usr/bin/env bash
cd $PRE_HOME/StartScripts-Datasets
./bin/spark-submit --deploy-mode=cluster --master=spark://10.22.1.1:10086 /home/wfan/DFT-Project/apps/build_examples/PreCount/target/scala-2.11/prefixcount_2.11-1.0.0.jar 
