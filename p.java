const nodemailer = require('nodemailer');

let transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
        user: 'seu-email@gmail.com',
        pass: 'sua-senha'
    }
});

// Processando o formulário
app.post('/send-email', (req, res) => {
    const { nome, email, telefone, mensagem } = req.body;

    let mailOptions = {
        from: email,
        to: 'seu-email@dominio.com',
        subject: 'Novo Contato de Lead',
        text: `Nome: ${nome}\nE-mail: ${email}\nTelefone: ${telefone}\nMensagem: ${mensagem}`
    };

    transporter.sendMail(mailOptions, (error, info) => {
        if (error) {
            return res.send('Erro ao enviar e-mail');
        }
        res.send('Mensagem enviada com sucesso!');
    });
});
