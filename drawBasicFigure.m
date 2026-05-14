data=xlsread('/Users/zhangziyi/Desktop/data',1,'A2:G1597');
failure_rate=data(:,1);
minsdk=data(:,2);
api=data(:,3);
year=data(:,4);
api_year=data(:,5);
api_minus_year=data(:,6);
api_minus_minsdk=data(:,7);
x=api_minus_minsdk;
y=api_minus_year;
z=failure_rate;

%draw 3D scatter diagram with input data
figure;
scatter3(x,y,z);
%title name may change
title('Failed installation percentage distribution among different API level');
t1=xlabel('API level - App minimum SDK version');
t2=ylabel('API lease Year - App develop year');
zlabel('Failure rate');

%draw bar chart with input data for installation
data_bar=xlsread('/Users/zhangziyi/Desktop/data',2,'B2:I9');

figure;
bar(data_bar);
title('install-failure rate-bar-chart');
xlabel('year');
ylabel('failure rate');
set(gca,'XtickLabel',{2010:2017});
legend('api19','api21','api22','api23','api24','api25','api26','api27');



