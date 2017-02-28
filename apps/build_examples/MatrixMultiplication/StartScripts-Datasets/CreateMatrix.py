import random
import getopt,sys
from datetime import datetime
random.seed(datetime.now())
try:
        opts,args = getopt.getopt(sys.argv[1:], "m:n:s:");
        for opt,arg in opts:
                if opt in ("-m"):
                        mat1_path=arg
                        print "mok"
                elif opt in ("-n"):
                        mat2_path=arg
                        print "nok"
                elif opt in ("-s"):
                        size=int(arg)
                        print "sok"
        fp1=open(mat1_path,'wb')
        fp2=open(mat2_path,'wb')
        for i in xrange(size):
                for j in xrange(size):
                        fp1.write(str(i+1)+' '+str(j+1)+' '+str(random.rand
int(1,10000))+'\n')
                        fp2.write(str(i+1)+' '+str(j+1)+' '+str(random.rand
int(1,10000))+'\n')

        fp1.close()
        fp2.close()
except getopt.GetoptError:
        print "usage: CreateMatrix.py -m <mat1> -n <mat2> -s <size>"
        sys.exit(1)
