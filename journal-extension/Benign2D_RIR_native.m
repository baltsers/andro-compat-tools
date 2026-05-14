data=xlsread('run-timeforSPSS.xlsx',2,'A2:G1345');
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
%scatter3(x,y,z);

scatter(x,y,30,z, 's', 'LineWidth', 5);
ylim([-4.5 8]);
xlim([-10 30]);
%zoom(2);
colorbar;

%title name may change
t1=xlabel('API lapse', 'FontSize',12,'Color','red');
t2=ylabel('App lapse', 'FontSize',12,'Color','blue');

%title name may change
% title('Native crash induced failed execution percentage distribution among different API level');
% t1=xlabel('API lapse', 'FontSize',12,'FontWeight','bold','Color','m');
% t2=ylabel('App lapse', 'FontSize',12,'FontWeight','bold','Color','r');
% zlabel('RIR', 'FontSize',12,'FontWeight','bold','Color','black');

fig = gcf;
fig.InvertHardcopy = 'off';
%saveas(gcf,'GrayBackground.pdf')

