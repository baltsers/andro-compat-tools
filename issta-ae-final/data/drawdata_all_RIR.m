data=xlsread('run-timeforSPSS.xlsx',1,'A2:G1793');
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
%set(gcf,'color',[.87 .87 .87]);
%XL = get(gca, 'XLim');
%YL = get(gca, 'YLim');
%patch([XL(1), XL(2), XL(2), XL(1)], [YL(1), YL(1), YL(2), YL(2)], [0 0 0 0 0], 'FaceColor', [0 1 0]);
scatter3(x,y,z);
%title name may change
title('Failed execution percentage distribution among different API level');
t1=xlabel('API lapse', 'FontSize',12,'FontWeight','bold','Color','m');
t2=ylabel('App lapse', 'FontSize',12,'FontWeight','bold','Color','r');
zlabel('IIR', 'FontSize',12,'FontWeight','bold','Color','black');

fig = gcf;
fig.InvertHardcopy = 'off';
%saveas(gcf,'GrayBackground.pdf')

%draw bar chart with input data for installation
data_bar=xlsread('run-timeforSPSS.xlsx',2,'B2:I9');

figure;
bar(data_bar);
title('runtime-failure rate-bar-chart');
xlabel('year');
ylabel('failure rate');
set(gca,'XtickLabel',{2010:2017});
legend('api19','api21','api22','api23','api24','api25','api26','api27');


