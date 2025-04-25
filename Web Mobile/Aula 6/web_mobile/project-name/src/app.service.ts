import { Injectable } from '@nestjs/common';

@Injectable()
export class AppService {
  convertCurrency(
    value: number,
    fromCurrency: string,
    toCurrency: string,
    rate: number,
  ): string {
    // Validação das moedas
    if (
      !['R$', '$'].includes(fromCurrency) ||
      !['R$', '$'].includes(toCurrency)
    ) {
      throw new Error('Moedas suportadas: R$ e $');
    }

    let convertedValue: number;

    // Conversão de Real para Dólar
    if (fromCurrency === 'R$' && toCurrency === '$') {
      convertedValue = value / rate;
    }
    // Conversão de Dólar para Real
    else if (fromCurrency === '$' && toCurrency === 'R$') {
      convertedValue = value * rate;
    }
    // Mesma moeda (não precisa conversão)
    else {
      convertedValue = value;
    }

    // Formatação do resultado
    return `O valor ${fromCurrency} ${value.toFixed(2)} convertido para ${toCurrency} com cotação de R$ ${rate.toFixed(2)} é ${toCurrency} ${convertedValue.toFixed(2)}.`;
  }
}
