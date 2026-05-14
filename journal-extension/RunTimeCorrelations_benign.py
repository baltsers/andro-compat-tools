from __future__ import print_function
import pandas as pd
import numpy as np
import scipy.stats  as stats

dfTotal = pd.read_excel('C:/Research/appcompatibilitystudy/Programs/run-timeforSPSS_benign.xlsx', sheet_name='total(all)')
#dfTotal = pd.read_excel('C:/Research/appcompatibilitystudy/androidincompat-artefact/run-timeforSPSS.xlsx', sheet_name='Total')

dfTotal_corr = pd.DataFrame() # Correlation matrix
# df_p = pd.DataFrame()  # Matrix of p-values
for x in dfTotal.columns:
    for y in dfTotal.columns:
        corr = stats.spearmanr(dfTotal[x], dfTotal[y])
        dfTotal_corr.loc[x,y] = corr[0]
#        df_p.loc[x,y] = corr[1]
        
print(dfTotal_corr)
#print(df_p)

writer1 = pd.ExcelWriter('C:/Research/appcompatibilitystudy/Programs/run-timeCorrelations_benign20102019_Total.xlsx')
dfTotal_corr.to_excel(writer1,'Total')
writer1.save()


dfnative = pd.read_excel('C:/Research/appcompatibilitystudy/Programs/run-timeforSPSS_benign.xlsx', sheet_name='native')
dfnative_corr = pd.DataFrame() # Correlation matrix
# df_p = pd.DataFrame()  # Matrix of p-values
for x in dfnative.columns:
    for y in dfnative.columns:
        corr = stats.spearmanr(dfnative[x], dfnative[y])
        dfnative_corr.loc[x,y] = corr[0]
#        df_p.loc[x,y] = corr[1]
        
print(dfnative_corr)
#print(df_p)

writer2 = pd.ExcelWriter('C:/Research/appcompatibilitystudy/Programs/run-timeCorrelations_benign20102019_native.xlsx')
dfnative_corr.to_excel(writer2,'native')
writer2.save()


dfverify = pd.read_excel('C:/Research/appcompatibilitystudy/Programs/run-timeforSPSS_benign.xlsx', sheet_name='verify')
dfverify_corr = pd.DataFrame() # Correlation matrix
# df_p = pd.DataFrame()  # Matrix of p-values
for x in dfverify.columns:
    for y in dfverify.columns:
        corr = stats.spearmanr(dfverify[x], dfverify[y])
        dfverify_corr.loc[x,y] = corr[0]
#        df_p.loc[x,y] = corr[1]
        
print(dfverify_corr)
#print(df_p)

writer3 = pd.ExcelWriter('C:/Research/appcompatibilitystudy/Programs/run-timeCorrelations_benign20102019_verify.xlsx')
dfverify_corr.to_excel(writer3,'verify')
writer3.save()


dfnull = pd.read_excel('C:/Research/appcompatibilitystudy/Programs/run-timeforSPSS_benign.xlsx', sheet_name='null')
dfnull_corr = pd.DataFrame() # Correlation matrix
# df_p = pd.DataFrame()  # Matrix of p-values
for x in dfnull.columns:
    for y in dfnull.columns:
        corr = stats.spearmanr(dfnull[x], dfnull[y])
        dfnull_corr.loc[x,y] = corr[0]
#        df_p.loc[x,y] = corr[1]
        
print(dfnull_corr)
#print(df_p)

writer4 = pd.ExcelWriter('C:/Research/appcompatibilitystudy/Programs/run-timeCorrelations_benign20102019_null.xlsx')
dfnull_corr.to_excel(writer4,'null')
writer4.save()
